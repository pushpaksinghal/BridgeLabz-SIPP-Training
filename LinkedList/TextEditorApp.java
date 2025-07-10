class TextStateNode {
    String content;
    TextStateNode prev, next;

    TextStateNode(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextStateNode current;
    private int size = 1;

    public TextEditor(String initialState) {
        current = new TextStateNode(initialState);
    }

    public void type(String newText) {
        TextStateNode newNode = new TextStateNode(current.content + newText);
        newNode.prev = current;
        current.next = newNode;
        current = newNode;

        // Remove any forward history
        current.next = null;

        // Maintain limit of 10 states
        int count = 1;
        TextStateNode temp = current;
        while (temp.prev != null) {
            count++;
            if (count > 10) {
                temp.prev.prev = null;
                temp.prev = null;
                break;
            }
            temp = temp.prev;
        }
    }

    public void undo() {
        if (current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void showText() {
        System.out.println("Current Text: \"" + current.content + "\"");
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor("");

        editor.type("Hello ");
        editor.type("world");
        editor.showText();  // Hello world

        System.out.println("\nUndo once:");
        editor.undo();
        editor.showText();  // Hello 

        System.out.println("\nRedo:");
        editor.redo();
        editor.showText();  // Hello world

        System.out.println("\nTyping more (undo history resets ahead):");
        editor.type("!");
        editor.showText();  // Hello world!

        System.out.println("\nUndo twice:");
        editor.undo();
        editor.undo();
        editor.showText();  // Hello 

        System.out.println("\nRedo once:");
        editor.redo();
        editor.showText();  // Hello world
    }
}
