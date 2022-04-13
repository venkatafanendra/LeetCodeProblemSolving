class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int item :nums){
            
            if(item>max1){
                max3=max2;
                max2=max1;
                max1=item;
            }
            else if(item>max2){
                max3=max2;
                max2=item;
            }
            else if(item>max3){
                max3=item;
            }
            
            if(item<min1){
                min2=min1;
                min1=item;
            }
            else if(item<min2){
                min2=item;
            }
        }
        return Math.max(max1*max2*max3,max1*min1*min2);
    }
}