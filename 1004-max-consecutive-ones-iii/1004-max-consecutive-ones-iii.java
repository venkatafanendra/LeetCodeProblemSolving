class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int maxi = 0;
        int count =0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                count++;  
            }
            while(count>k){
                if(nums[l]==0)
                    count--;
                l++;
            }
           maxi = Math.max(maxi,r-l+1); 
        }
        return maxi;
    }
}