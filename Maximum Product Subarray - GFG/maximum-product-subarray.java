// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long min_end = arr[0];
        long max_end = arr[0];
        long max_final = arr[0];
        for(int i=1;i<n;i++) {
            if(arr[i]<0) {
                long temp = max_end;
                max_end=min_end;
                min_end=temp;
            }
            min_end = Math.min(arr[i],min_end*arr[i]);
            max_end = Math.max(arr[i],max_end*arr[i]);
            max_final=Math.max(max_final,max_end);
        }
        return max_final;
    }
}