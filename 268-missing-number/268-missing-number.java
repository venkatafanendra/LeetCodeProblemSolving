class Solution {
    public int missingNumber(int[] nums) {
        int x1=nums[0];
        int x2=1;
        for(int i=1;i<nums.length;i++)
            x1=x1^nums[i];
        for(int i=2;i<=nums.length;i++)
            x2=x2^i;
        return x1^x2;
    }
}