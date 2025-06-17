import java.util.Scanner;

public  class StringIndexOutOfBoundsEx{
	public static void main(String[]args) {
		Scanner sc =new Scanner(System.in);
		String age =sc.next();
		try {
			System.out.println(age.charAt(age.length()+1));
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBoundsException => " + e.getMessage());
		}catch(Exception e) {
			System.out.println("generic Exception => " + e.getMessage());
		}
	}
}	