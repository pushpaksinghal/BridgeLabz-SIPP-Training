import java.util.*;

class Productss {
    private String name;
    private double price;

    public Productss(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private static int count = 1;
    private int orderId;
    private Customerss customer;
    private List<Productss> products;

    public Order(Customerss customer) {
        this.orderId = count++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Productss product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " by Customer: " + customer.getName());
        double total = 0;
        for (Productss p : products) {
            System.out.println(" - " + p.getName() + ": ₹" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total Amount: ₹" + total);
    }
}

class Customerss {
    private String name;
    private List<Order> orders;

    public Customerss(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order.");
    }

    public void showOrderHistory() {
        System.out.println("Order history for " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class ecommerceplatform {
    public static void main(String[] args) {
    	Productss p1 = new Productss("Laptop", 60000);
        Productss p2 = new Productss("Mouse", 500);
        Productss p3 = new Productss("Keyboard", 1500);

        Customerss c1 = new Customerss("Anita");

        Order order1 = new Order(c1);
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = new Order(c1);
        order2.addProduct(p3);

        c1.placeOrder(order1);
        c1.placeOrder(order2);

        c1.showOrderHistory();
    }
}
