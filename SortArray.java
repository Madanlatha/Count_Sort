package countsort;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
	 
	public static int getMax(int[] arr, int n) {  
	  int max = arr[0];  
	  for(int i = 1; i<n; i++) {  
	      if(arr[i] > max)  
	         max = arr[i];  
	  }  
	  return max;
	}  
	  
	public static void countSort(int[] a, int n) 
	{  
	   int[] output = new int [n+1];  
	   int max = getMax(a, n);  
	   int[] count = new int [max+1]; 
	   for (int i = 0; i <= max; ++i)   
	   {  
		   count[i] = 0;
		   }  
	   for (int i = 0; i < n; i++)
	   {  
		   count[a[i]]++;  
		}  
	   for(int i = 1; i<=max; i++) {
		   count[i] += count[i-1];   
	   }
	   for (int i = n - 1; i >= 0; i--) {  
	    output[count[a[i]] - 1] = a[i];  
	    count[a[i]]--;   
	    }  
	  
	   for(int i = 0; i<n; i++) {  
	      a[i] = output[i];   
	   }
	}  
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		countSort(a,n);
		System.out.println(Arrays.toString(a));

	}

}
