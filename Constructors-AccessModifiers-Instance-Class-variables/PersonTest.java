class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void display() {
        System.out.println(name + ", " + age);
    }
}

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person(p1);
        p1.display();
        p2.display();
    }
}
