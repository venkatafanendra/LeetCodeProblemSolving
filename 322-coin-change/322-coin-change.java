class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int n=coins.length;
        Arrays.sort(coins);
        int dp[][]=new int[n][amount+1];
        for(int j=0;j<=amount;j++){
            if(j%coins[0]==0)
                dp[0][j]=j/coins[0];
            else
                dp[0][j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                if(j<coins[i])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i]]);
            }
        }
        return dp[n-1][amount]!=(Integer.MAX_VALUE-1)?dp[n-1][amount]:-1;
    }
}