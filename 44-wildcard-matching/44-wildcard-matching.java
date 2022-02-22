class Solution {
    public boolean isMatch(String s, String p) {
        char st[] = s.toCharArray();
        char pt[] = p.toCharArray();
        int m = s.length();
        int n = p.length();
        int writeIndex = 0;
        boolean isFirst = true;
        for(int i=0;i<n;i++){
            if(pt[i]=='*'){
                if(isFirst){
                    pt[writeIndex++]=pt[i];
                    isFirst=false;
                }  
            } else {
                pt[writeIndex++]=pt[i];
                isFirst=true;
            }
        }
        boolean dp[][]=new boolean[m+1][writeIndex+1];
        dp[0][0]=true;
        if(pt.length>0 && pt[0]=='*')
            dp[0][1]=true;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=writeIndex;j++){
                if(st[i-1]==pt[j-1] || pt[j-1]=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pt[j-1]=='*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
            }
        }
        return dp[m][writeIndex];
    }
}