class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || prices.length==1 || k==0)
            return 0;
        int dp[][]=new int[k+1][prices.length];
        for(int i=1;i<=k;i++) {
            int maxDiff = dp[i-1][0]-prices[0];
            for(int j=1;j<prices.length;j++){
                dp[i][j]=Math.max(dp[i][j-1],maxDiff+prices[j]);
                maxDiff=Math.max(maxDiff,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
}