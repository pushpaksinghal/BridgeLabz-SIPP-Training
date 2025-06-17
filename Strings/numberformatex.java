import java.util.*;

public class numberformatex{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		try {
			int n = Integer.parseInt(s);
			System.out.println(n);
		}catch(NumberFormatException e) {
			System.out.println("NumberFormatException => "+ e.getMessage());
		}catch(Exception e) {
			System.out.println("Generic Exception => "+ e.getMessage());
		}
	}
}