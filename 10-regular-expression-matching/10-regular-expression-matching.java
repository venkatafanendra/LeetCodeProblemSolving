class Solution {
    public boolean isMatch(String s, String p) {
        char st[] = s.toCharArray();
        char pt[] = p.toCharArray();
        int m = st.length;
        int n = pt.length;
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++)
            if(pt[i-1]=='*')
                dp[0][i]=dp[0][i-2];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(st[i-1]==pt[j-1] || pt[j-1]=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(pt[j-1]=='*') {
                    dp[i][j]=dp[i][j-2];
                    if(st[i-1]==pt[j-2] || pt[j-2]=='.')
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                }
            }
        }
        return dp[m][n];  
    }
}