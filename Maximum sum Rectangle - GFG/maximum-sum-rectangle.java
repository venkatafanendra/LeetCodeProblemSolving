// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        int kadane[] = new int[R];
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<C;i++){
            Arrays.fill(kadane,0);
            for(int j=i;j<C;j++){
                for(int k=0;k<R;k++ )
                    kadane[k]+=M[k][j]; 
                int currSum = kdAlgo(kadane);
                if(currSum>maxSum)
                    maxSum = currSum;
            }
        }
        return maxSum;
    }
    private int kdAlgo(int a[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0;i<a.length;i++){
            currSum+=a[i];
            if(currSum>maxSum)
             maxSum=currSum;
            if(currSum<0)
                currSum=0;
            
        }
        return maxSum;
    }
};