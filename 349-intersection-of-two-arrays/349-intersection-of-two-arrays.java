class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> res = new HashSet<>();
        int i=0,j=0;
        while(i<n && j<m) {
           if(nums1[i]<nums2[j]) {
               i++;
           }
           else if(nums1[i]>nums2[j]) {
               j++;
           }
           else {
               res.add(nums1[i]);
               i++;
               j++;
           } 
           
        }
        int fin[] = new int[res.size()];
        int c=0;
        for(int x : res)
            fin[c++]=x;
        return fin;
    }
}