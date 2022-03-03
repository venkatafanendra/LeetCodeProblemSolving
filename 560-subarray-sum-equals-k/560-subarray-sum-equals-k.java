class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum=0;
        int res=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(currSum==k)
                res++;
            if(map.containsKey(currSum-k))
                res+=map.get(currSum-k);
            Integer count = map.get(currSum);
            if(count==null){
                map.put(currSum,1);
            }
            else {
                map.put(currSum,count+1);
            }
        }
        return res;
    }
}