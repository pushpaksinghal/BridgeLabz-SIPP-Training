import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equals(itemName)) {
                items.remove(i);
                break;
            }
        }
    }

    public void displayTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.price * item.quantity;
        }
        System.out.println("Total Cost: ₹" + total);
    }
}

public class ShoppingCartApp  {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartItem item1 = new CartItem("Pen", 10, 2);
        CartItem item2 = new CartItem("Notebook", 50, 1);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.removeItem("Pen");

        cart.displayTotalCost();
    }
}
