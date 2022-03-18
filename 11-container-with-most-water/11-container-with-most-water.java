class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int maxLeft=0;
        int maxRight=0;
        int ans=0;
        int left=0;
        int right=n-1;
        while(left<right){
            if(height[left]<height[right]){
                
                ans=Math.max(ans,height[left]*(right-left));
                
                left++;
            }
            else {
                
                ans=Math.max(ans,height[right]*(right-left));
                   right--;
                } 
                
            }
        return ans;
    }
}