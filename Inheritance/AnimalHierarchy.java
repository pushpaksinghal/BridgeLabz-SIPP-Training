class animal{
	int age;
	String name;
	
	animal(int age,String name){
		this.name = name;
		this.age = age;
	}
	
	void makesound() {
		System.out.println("animal can make a sound");
	}
}

class Dog extends animal{
	Dog(int age, String name) {
		super(age, name);
	}

	@Override
	void makesound() {
		System.out.println("A dog Barks");
	}
}
class Cat extends animal{
	Cat(int age, String name) {
		super(age, name);
	}

	@Override
	void makesound() {
		System.out.println("A cat meows");
	}
}

class Birds extends animal{
	Birds(int age, String name) {
		super(age, name);
	}

	@Override
	void makesound() {
		System.out.println("A Bird sings");
	}
}

public class AnimalHierarchy{
	public static void main(String[]args) {
		
		Dog d1 = new Dog(12,"ted");
		animal d2 = new animal(10,"red");
		Cat c1 = new Cat(11,"mmm");
		Birds b1 = new Birds(1,"ffasf");
		
		d1.makesound();
		d2.makesound();
		c1.makesound();
		b1.makesound();
	}
}