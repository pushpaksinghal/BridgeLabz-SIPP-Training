interface Worker {
    void performDuties();
}

class son {
    String name;
    int id;

    son(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends son implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Preparing dishes. Specialty: " + specialty);
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends son implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println("Serving customers at " + tablesAssigned + " tables.");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Alice", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Bob", 202, 5);

        chef.displayInfo();
        chef.performDuties();
        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
