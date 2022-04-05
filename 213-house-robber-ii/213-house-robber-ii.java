class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
           return 0;
        if(nums.length==1)
           return nums[0];
        return Math.max(robhelper(nums,0,nums.length-2),robhelper(nums,1,nums.length-1));
    }
    private int robhelper(int[] nums,int start,int end){
        int first=0,second=0;
        for(int i=start;i<=end;i++){
            int temp=first;
            first=Math.max(second+nums[i],first);
            second=temp;
        }
        return first;
    }
}