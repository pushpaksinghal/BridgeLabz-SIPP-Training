
import java.util.*;
public class mergesort22{
	static void mergesort(int []arr, int left , int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergesort(arr,left,mid);
			mergesort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	static void merge(int []arr,int left, int mid,int right) {
		int n1 = (mid-left)+1;
		int n2 = right-mid;
		int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
	}
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		mergesort(arr,0,arr.length-1);
		for(Integer i:arr) {
			System.out.println(i+"");
		}
		
		
	}
}