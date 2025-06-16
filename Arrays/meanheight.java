import java.util.*;

public class meanheight{
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);;
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int count =0;
		for(int i=0;i<n;i++) {
			count=  count+arr[i];
		}
		System.out.print("the mean height of "+n+" football players is "+ (count/n));
		
		
	}
}