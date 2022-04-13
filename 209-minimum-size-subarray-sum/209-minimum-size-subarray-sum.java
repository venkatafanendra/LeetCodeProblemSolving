class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0,i=0,j=0,ans=Integer.MAX_VALUE;
        
        for(i=0;i<nums.length;i++){
            sum=sum+nums[i];
            while(sum>=target){
                ans=Math.min(ans,i-j+1);
                sum=sum-nums[j];
                j++;
            }
        }
        return ans!=Integer.MAX_VALUE ? ans : 0;
    }
}