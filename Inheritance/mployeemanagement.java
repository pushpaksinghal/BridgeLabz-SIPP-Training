class mployees{
	String name;
	int id;
	double Salary;
	
	mployees(String name,int id,double Salary){
		this.name= name;
		this.id =id;
		this.Salary = Salary;
	}
	
	void showDetails() {
		System.out.println("employee name:" + name);
		System.out.println("employee id:" + id);
		System.out.println("employee Salary:" + Salary);
	}
}

class anager extends mployees{
	int teamSize;
	anager(String name,int id,double Salary,int teamSize){
		super(name,id,Salary);
		this.teamSize = teamSize;
	}
	
	@Override
	void showDetails() {
		super.showDetails();
		System.out.println("team size:"+ teamSize);
	}
}

class Developer extends mployees{
	String language;
	Developer(String name,int id,double Salary,String language){
		super(name,id,Salary);
		this.language = language;
	}
	
	@Override
	void showDetails() {
		super.showDetails();
		System.out.println("Language known:"+ language);
	}
}

class intern extends mployees{
	int monthslong;
	intern(String name,int id,double Salary,int monthslong){
		super(name,id,Salary);
		this.monthslong = monthslong;
	}
	
	@Override
	void showDetails() {
		super.showDetails();
		System.out.println("Months the internship will go on:"+ monthslong);
	}
}

public class mployeemanagement{
	public static void main(String[]args) {
		intern i1 = new intern ("pushpak singhal",001,100000.00,6);
		Developer d1 = new Developer("pushpak singhal",001,100000.00,"java");
		anager m1 = new anager("pushpak singhal",001,100000.00,20);
		
		i1.showDetails();
		d1.showDetails();
		m1.showDetails();
	}
}