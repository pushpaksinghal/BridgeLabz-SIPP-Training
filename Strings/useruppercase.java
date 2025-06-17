import java.util.*;

public class useruppercase{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s =sc.next();
		String upper = "";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c>='a' && c<='z') {
				c = (char)(c-32);
			}
			upper +=c;
			
		}
		System.out.println(upper);
	}
}