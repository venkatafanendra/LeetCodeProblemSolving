class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int len=nums.length;
        int ans=0;
        int currSum=0 ;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<len;i++){
            if(nums[i]%2==1)
                nums[i]=1;
            else
                nums[i]=0;
        }
        for(int i=0;i<len;i++){
            currSum +=nums[i];
            if(currSum==k)
                ans++;
            if(map.containsKey(currSum-k))
                ans+=map.get(currSum-k);
            Integer count = map.get(currSum);
            if(count==null){
               map.put(currSum,1); 
            }
            else{
                map.put(currSum,count+1);
            }
        }
        return ans;
    }
}