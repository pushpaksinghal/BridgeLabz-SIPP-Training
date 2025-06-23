class Employee {
	String name;
	int id;
	double salary;
	
	Employee (String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	void ShowEmployeeDetails(){
		System.out.print("Name: " +name+", ID: " +id+", Salary: "+salary);
	}
}


public class EmployeeDetails{
	public static void main(String[]args) {
		Employee e1 = new Employee("Pushpak",001,1000000);
		e1.ShowEmployeeDetails();
	}
}