import java.util.*;

public class  numbercheck{
	public static void main(String [] args) {
		Scanner sc =new Scanner(System.in);
		int arr[]  = new int[5];
		for (int i=0;i<5;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<5;i++){
			if(arr[i]>0) {
				System.out.println("positive");
				if(arr[i] %2==0) {
					System.out.println("eevn");
				}
				else {
					System.out.println("odd");
				}
			}
			else if(arr[i]<0) {
				System.out.println("negetive");
			}
			else {
				System.out.println("it is zzero");
			}
		}
		if(arr[0]>arr[4]) {
			System.out.println(arr[0]+" is greater then " +arr[4]);
		}
		else if(arr[0]<arr[4]) {
			System.out.println(arr[0]+" is smaller then " +arr[4]);
		}
		else {
			System.out.println("both are equal");
		}
		
	}
}