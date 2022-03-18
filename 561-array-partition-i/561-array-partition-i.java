class Solution {
    public int arrayPairSum(int[] nums) {
        //highest minimum possible in each pair 
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2)
            sum=sum+nums[i];
        return sum;
    }
}