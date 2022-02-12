// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            System.out.println(new Solution().findNum(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        int ans=0;
        int low=0;
        int high=5*n;
        while(low<=high) {
            int mid=(low+high)/2;
            if(check(n,mid)) {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    boolean check(int n,int mid)
    {
        int ans = 0 ;
        int p=5;
        while((mid/p)>0)
        {
            ans+=(mid/p);
            p=p*5;
        }
        if(ans>=n)
         return true;
        return false;
    }
}