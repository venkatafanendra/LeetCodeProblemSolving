class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int temp : nums)
            sum+=temp;
        if(sum%2==1)
            return false;
        int target=sum/2;
        boolean dp[][]=new boolean[nums.length][target+1];
        for(int j=0;j<=target;j++){
            if(nums[0]==j)
                dp[0][j]=true;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                if(j<nums[i])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
            }
        }
        return dp[nums.length-1][target];
    }
}