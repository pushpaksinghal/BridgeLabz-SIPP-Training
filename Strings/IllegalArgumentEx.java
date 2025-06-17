import java.util.*;

public  class IllegalArgumentEx{
	public static void main(String[]args) {
		Scanner sc =new Scanner(System.in);
		int age =sc.nextInt();
		try {
			if(age<0) {
				throw new IllegalArgumentException("exception thrown") ;
			}
			else {
				System.out.print("your age is" + age);
			}
			
		}catch(IllegalArgumentException e) {
			System.out.println("IllegalArgumentException => " + e.getMessage());
		}catch(Exception e) {
			System.out.println("generic Exception => " + e.getMessage());
		}
	}
}	