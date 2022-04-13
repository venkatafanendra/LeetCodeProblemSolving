class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int prod=1,i=0,j=0,ans=0;
        for(i=0;i<nums.length;i++){
            prod=prod*nums[i];
            while(prod>=k){
                prod=prod/nums[j];
                j++;
            }
            ans=ans+i-j+1;
        }
        return ans;
    }
}