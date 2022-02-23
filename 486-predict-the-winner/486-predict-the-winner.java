class Solution {
    class Pair {
        int first;
        int second;
    }
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        Pair dp[][]=new Pair[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new Pair();
            }
        }
        for(int i=0;i<n;i++){
            dp[i][i].first=nums[i];
        }
        for(int l=2;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                if(nums[i]+dp[i+1][j].second>dp[i][j-1].second+nums[j]){
                    dp[i][j].first=nums[i]+dp[i+1][j].second;
                    dp[i][j].second=dp[i+1][j].first;
                }else{
                    dp[i][j].first=dp[i][j-1].second+nums[j];
                    dp[i][j].second=dp[i][j-1].first;
                }
            }
        }
        return dp[0][n-1].first>=dp[0][n-1].second ? true : false ;
    }
}