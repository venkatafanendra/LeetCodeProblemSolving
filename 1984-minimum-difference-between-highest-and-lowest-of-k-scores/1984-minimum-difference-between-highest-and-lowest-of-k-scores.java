class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int j=0;
        int ans=Integer.MAX_VALUE;
        while(j<=nums.length-k){
            int high=nums[j+k-1];
            int low=nums[j];
            ans=Math.min(ans,high-low);
            j++;
        }
        return ans;
    }
}