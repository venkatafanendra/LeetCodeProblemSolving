// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int res = -1;
        Arrays.sort(A);
        int low = A[0];
        int high = 0;
        for(int i=0;i<N;i++)
         high=high+A[i];
        while(low<=high) {
            int mid = (low+high)/2;
            if(check(A,N,M,mid)){
                high=mid-1;
                res=mid;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    private static boolean check(int[] A,int N,int M,int mid) {
        int allocStud=1;
        int pages=0;
        for(int i=0;i<N;i++) {
            if(A[i]>mid)
             return false;
            if(pages+A[i]>mid) {
                allocStud++;
                pages=A[i];
            }
            else{
                pages+=A[i];
            }
        }
        if(allocStud>M)
         return false;
        
        return true;
    }
}