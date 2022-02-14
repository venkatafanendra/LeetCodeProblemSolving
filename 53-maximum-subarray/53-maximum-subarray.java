class Solution {
    public int maxSubArray(int[] nums) {
        //int min_end = nums[0];
        int max_end = nums[0];
        int max_sum = nums[0];
        for(int i=1;i<nums.length;i++) {
            //min_end = Math.min(nums[i],min_end+nums[i]);
            max_end = Math.max(nums[i],max_end+nums[i]);
            max_sum = Math.max(max_sum,max_end);
        }
        return max_sum;
    }
}