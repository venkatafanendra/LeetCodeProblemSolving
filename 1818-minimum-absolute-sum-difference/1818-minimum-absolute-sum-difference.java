class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int sorted[] = nums1.clone();
        Arrays.sort(sorted);
        long sumDiff = 0;
        int mx=Integer.MIN_VALUE;
        int diff=0,index=-1;
        for(int i=0;i<nums2.length;i++){
            diff = Math.abs(nums1[i]-nums2[i]);
            sumDiff+=diff;
            index = Arrays.binarySearch(sorted,nums2[i]);
            if(index<0)
                index=-1*(index+1);
            if(index<sorted.length)
                mx=Math.max(mx,diff-Math.abs(sorted[index]-nums2[i]));
            if(index>0)
                mx=Math.max(mx,diff-Math.abs(sorted[index-1]-nums2[i]));
        }
        return (int)((sumDiff-mx)%1000000007);
    }
}