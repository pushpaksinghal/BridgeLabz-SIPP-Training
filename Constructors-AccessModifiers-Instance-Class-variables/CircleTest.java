class Circles{
    double radius;

    Circles() {
        this(1.0);
    }

    Circles(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Circles c1 = new Circles();
        Circles c2 = new Circles(5.5);
        c1.display();
        c2.display();
    }
}
