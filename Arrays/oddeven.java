import java.util.*;

public class oddeven{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int temp=0;
//		int even[] = new int [(n/2)+1];
//		int odd[] = new int [(n/2)+1];
		ArrayList<Integer>even = new ArrayList<>();
		ArrayList<Integer>odd = new ArrayList<>();
		while(n>0) {
			temp = sc.nextInt();
			if(temp==0) {
				System.out.println("enter a netural number");
				break;
			}
			else {
				if(temp%2==0){
					even.add(temp);
				}
				else {
					odd.add(temp);
					
				}
			}
			n--;
		}
		
		for(int i=0;i<even.size();i++) {
			System.out.print(even.get(i)+" ");
		}
		System.out.println();
		for(int i=0;i<odd.size();i++) {
			System.out.print(odd.get(i)+" ");
		}
	}
}