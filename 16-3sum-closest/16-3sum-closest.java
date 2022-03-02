class Solution {
    public int threeSumClosest(int[] nums, int target) {
        long closetSum = Integer.MAX_VALUE; // for overflow
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int low=i+1;
            int high=nums.length-1;
            while(low<high){
                int sum = nums[i]+nums[low]+nums[high];
                if(Math.abs(target-sum)<Math.abs(target-closetSum))
                    closetSum=sum;
                if(sum>target)
                    high--;
                else
                    low++;
            }
        }
        return (int) closetSum;
    }
}