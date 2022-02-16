class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,f=m+n-1;
        while(i>=0 && j>=0){
           if(nums1[i]>nums2[j]) {
               nums1[f]=nums1[i];
               f--;
               i--;
           }
           else{
               nums1[f]=nums2[j];
               f--;
               j--;
           }
        }
        while(j>=0) {
            nums1[f]=nums2[j];
            f--;
            j--;
        }
        
    }
}