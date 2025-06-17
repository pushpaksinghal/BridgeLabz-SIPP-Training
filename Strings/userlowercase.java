import java.util.*;

public class userlowercase{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String lowercase = usertolowercase(s); 
		String lower = s.toLowerCase();
		if(lower.equals(lowercase)) {
			System.out.println(true);
			
		}
		else {
			System.out.println(false);
		}
	}
	public static String usertolowercase(String s) {
		String ans ="";
		for(int i=0;i<s.length();i++) {
			char c= s.charAt(i);
			if(c>='A' && c<='Z') {
				c = (char)(c+32);
			}
			ans = ans+c;
		}
		
		return ans;
	}
}