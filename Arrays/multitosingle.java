import java.util.*;

public class multitosingle{
	public static void main(String[] srgs) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr2d[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr2d[i][j] = sc.nextInt();
			}
		}
		
		int arr1d[] = new int[n*m];
		int k=0;
		while(k<(n*m)) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					arr1d[k]=arr2d[i][j];
					k++;
				}
			}
		}
		
		for(int i=0;i<(n*m);i++) {
			System.out.print(arr1d[i]+" ");
		}
	}
}