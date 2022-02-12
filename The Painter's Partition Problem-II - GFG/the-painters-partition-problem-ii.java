// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        long minTime=0;
        long low=arr[0];
        long high=0;
        for(int i=0;i<n;i++)
         high=high+arr[i];
        while(low<=high) {
            long mid=(low+high)/2;
            if(isPossible(arr,n,k,mid)){
                minTime = mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return minTime;
    }
    static boolean isPossible(int[] arr,int n,int k,long mid) {
        int painters = 1;
        int blen=0;
        for(int i=0;i<n;i++) {
            if(arr[i]>mid)
              return false;
             if(arr[i]+blen>mid) {
                 blen=arr[i];
                 painters++;
             }
             else{
                 blen = blen+arr[i];
             }
        }
        if(painters>k)
         return false;
        return true;
    }
}


