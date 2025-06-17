import java.util.*;

public class usersubstring{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String sub1 = s.substring(1,3);
		String sub2 = "";
		for(int i=1;i<3;i++) {
			sub2 = sub2+s.charAt(i);
		}
		
		System.out.println(sub2);
		System.out.println(sub1.equals(sub2));
	}
}