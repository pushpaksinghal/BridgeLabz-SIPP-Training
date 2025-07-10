class InventoryItem {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryItem next;

    InventoryItem(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    private InventoryItem head;

    public void addAtBeginning(String name, int id, int qty, double price) {
        InventoryItem newNode = new InventoryItem(name, id, qty, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(String name, int id, int qty, double price) {
        InventoryItem newNode = new InventoryItem(name, id, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos == 0) {
            addAtBeginning(name, id, qty, price);
            return;
        }
        InventoryItem newNode = new InventoryItem(name, id, qty, price);
        InventoryItem temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null)
            return;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeById(int id) {
        if (head == null)
            return;
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        InventoryItem temp = head;
        while (temp.next != null && temp.next.itemId != id)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int newQty) {
        InventoryItem temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByIdOrName(String query) {
        InventoryItem temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(query) || temp.itemName.equalsIgnoreCase(query)) {
                System.out.println("Found: " + temp.itemName + " | ID: " + temp.itemId + " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found: " + query);
    }

    public void displayInventory() {
        InventoryItem temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " | ID: " + temp.itemId + " | Qty: " + temp.quantity + " | Price: " + temp.price);
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        InventoryItem temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + total);
    }

    public void sortBy(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
    }

    private InventoryItem mergeSort(InventoryItem node, String key, boolean asc) {
        if (node == null || node.next == null)
            return node;

        InventoryItem middle = getMiddle(node);
        InventoryItem nextToMiddle = middle.next;
        middle.next = null;

        InventoryItem left = mergeSort(node, key, asc);
        InventoryItem right = mergeSort(nextToMiddle, key, asc);

        return sortedMerge(left, right, key, asc);
    }

    private InventoryItem sortedMerge(InventoryItem a, InventoryItem b, String key, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (key.equals("name"))
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        else
            condition = asc ? a.price <= b.price : a.price > b.price;

        InventoryItem result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, key, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, key, asc);
        }

        return result;
    }

    private InventoryItem getMiddle(InventoryItem node) {
        if (node == null) return node;
        InventoryItem slow = node, fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
public class InventoryManagementApp {
    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();

        inventory.addAtEnd("Keyboard", 101, 10, 499.99);
        inventory.addAtBeginning("Mouse", 102, 20, 299.50);
        inventory.addAtPosition(1, "Monitor", 103, 5, 999.99);

        System.out.println("Inventory:");
        inventory.displayInventory();

        System.out.println("\nUpdate Quantity of Item ID 101:");
        inventory.updateQuantity(101, 15);
        inventory.displayInventory();

        System.out.println("\nSearch for Item 'Monitor':");
        inventory.searchByIdOrName("Monitor");

        System.out.println("\nTotal Inventory Value:");
        inventory.totalInventoryValue();

        System.out.println("\nSorted by Price Descending:");
        inventory.sortBy("price", false);
        inventory.displayInventory();
    }
}
