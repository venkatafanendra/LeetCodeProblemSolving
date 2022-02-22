class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
            dp[i][i]=1;
        for(int L=2;L<=n;L++){
            for(int i=0;i<n-L+1;i++){
                int j=i+L-1;
                if(s.charAt(i)==s.charAt(j) && L==2)
                    dp[i][j]=2;
                else if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=2+dp[i+1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }
}