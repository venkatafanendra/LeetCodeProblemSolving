// { Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            String ans = new Solution().solve(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java





class Solution {
    String solve(int[] arr, int n) {
        Arrays.sort(arr);
        reverse(arr);
        StringBuilder sb=new StringBuilder();
        int i=0;
        int carry=0;
        while(i<n){
            int a = arr[i++];
            int b=0;
            if(i!=n)
            b=arr[i++];
            int sum=a+b+carry;
            if(sum>9)
                carry=1;
            else
                carry=0;
            sum=sum%10;
            sb.append(sum);
        }
        if(carry==1)
            sb.append(1);
        while(sb.charAt(sb.length()-1)=='0')
         sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }
    public static void reverse(int[] array)
    {
  
        // Length of the array
        int n = array.length;
  
        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {
  
            // Storing the first half elements temporarily
            int temp = array[i];
  
            // Assigning the first half to the last half
            array[i] = array[n - i - 1];
  
            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}
