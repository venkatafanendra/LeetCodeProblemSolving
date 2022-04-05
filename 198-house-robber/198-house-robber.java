class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int first=0;
        int second=0;
        for(int i=0;i<nums.length;i++){
            int temp=first;
            first = Math.max(second+nums[i],first);
            second=temp;
        }
        return first;
    }
}