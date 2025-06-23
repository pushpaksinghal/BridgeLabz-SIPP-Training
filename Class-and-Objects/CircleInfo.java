class Circle{
	double radius;
	
	Circle(double radius){
		this.radius = radius;
	}
	
	void area() {
		System.out.println("Area of the circle : " + (3.14*radius*radius));
	}
	void parameter(){
		System.out.println("Parameter of a circle : " +(2*3.14*radius));
	}
}



public class CircleInfo{
	public static void main(String[]args) {
		Circle c1 = new Circle(3.11);
		c1.area();
		c1.parameter();
	}
}