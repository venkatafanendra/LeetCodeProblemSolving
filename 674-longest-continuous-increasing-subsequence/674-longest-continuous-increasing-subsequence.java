class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans=1;
        int start=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                ans=Math.max(ans,i-start+1);
            }else{
                start = i;
            }
        }
        return ans;
    }
}