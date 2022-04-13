class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for(int item:nums)
            sum+=item;
        if(sum<target || target<-sum)
            return 0;
        int dp[][] = new int[n+1][2*sum+1];
        dp[0][sum]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=2*sum;j++){
               if((j+nums[i-1])<=2*sum) 
                   dp[i][j]=dp[i][j]+dp[i-1][j+nums[i-1]];
               if((j-nums[i-1])>=0)
                   dp[i][j]=dp[i][j]+dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum+target];
    }
}