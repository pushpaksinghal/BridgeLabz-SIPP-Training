import java.util.*;

public class ArrayOutOFInderxex{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String [] names = new String[n];
		for(int i=0;i<n;i++) {
			names[i] = sc.next();
		}
		 try {
			for(int i=0;i<=n;i++) {
				System.out.println(names[i]);
			}
		 }catch(ArrayIndexOutOfBoundsException e) {
			 System.out.println("ArrayIndexOutOfBoundsException => "+ e.getMessage());
		 }catch(Exception e) {
				System.out.println("Generic Exception => "+ e.getMessage());
		}
	}
}