class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int res[] = new int[m];
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i=0;i<m;i++)
            res[i]=map.getOrDefault(nums1[i],-1);
        return res;
    }
}