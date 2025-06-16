import java.util.*;

public class agestudents{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<10;i++) {
			if(arr[i]>=18) {
				System.out.println("the student can vote");
			}
			else {
				System.out.println("the student cannot vote");
			}
		}
	}
}