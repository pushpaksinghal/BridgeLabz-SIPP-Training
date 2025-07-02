class Ord {
    String orderId;
    String orderDate;

    Ord(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed";
    }

    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Ord {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order shipped";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order delivered";
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class RetailOrderSystem {
    public static void main(String[] args) {
        Ord order = new Ord("ORD001", "2025-06-20");
        ShippedOrder shipped = new ShippedOrder("ORD002", "2025-06-18", "TRK12345");
        DeliveredOrder delivered = new DeliveredOrder("ORD003", "2025-06-15", "TRK67890", "2025-06-19");

        order.displayInfo();
        System.out.println();

        shipped.displayInfo();
        System.out.println();

        delivered.displayInfo();
    }
}
