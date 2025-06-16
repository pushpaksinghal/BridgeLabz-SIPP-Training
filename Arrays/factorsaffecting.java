import java.util.*;

public class factorsaffecting{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer>arr = new ArrayList<>();
		int j=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				arr.add(i);
				j++;
			}
		}
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
}