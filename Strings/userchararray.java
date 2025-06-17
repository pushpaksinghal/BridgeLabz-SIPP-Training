import java.util.*;

public class userchararray{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s= sc.next();
		char[] c = s.toCharArray();
		char[] userc = new char[s.length()];
		for(int i=0;i<s.length();i++) {
			userc[i] = s.charAt(i);
		}
		boolean ifsame = true;
		for(int i=0;i<s.length();i++) {
			if(c[i]==userc[i]) {
				System.out.print(userc[i]+" ");
				continue;
			}
			else {
				ifsame = false;
			}
		}
		System.out.println();
		System.out.println(ifsame);
	}
}