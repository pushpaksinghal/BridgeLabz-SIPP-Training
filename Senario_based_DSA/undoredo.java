import java.util.LinkedList;

class state{
	String text;
	
	state(String text){
		this.text = text;
	}
}

class UR{
	private LinkedList<state> undostack = new LinkedList<>();
	private LinkedList<state> redostack = new LinkedList<>();
	private String current ="";
	
	public void write(String text) {
		undostack.push(new state(current));
		current+=text;
		redostack.clear();
	}
	
	public void undo() {
		if(!undostack.isEmpty()){
			redostack.push(new state(current));
			current = undostack.pop().text;
		}
		else {
			System.out.println("Nothing to undo.");
		}
		
	}
	
	public void redo() {
		if(!redostack.isEmpty()){
			undostack.push(new state(current));
			current = redostack.pop().text;
		}
		else {
			System.out.println("Nothing to undo.");
		}
	}
	
	public void print() {
		System.out.println("current text : " + current);
	}
}

public class undoredo{
	public static void main(String[]args) {
		UR  t1 = new UR();
		
		t1.write("hello");
		t1.write("world");
		t1.undo();
		t1.redo();
		t1.undo();
		t1.print();
	}
}