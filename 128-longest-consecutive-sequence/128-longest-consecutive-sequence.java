class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        for(Integer x : nums)
            set.add(x);
        for(int i=0;i<nums.length;i++) {
            if(!set.contains(nums[i]-1)){
                int j=nums[i];
                while(set.contains(j))
                    j++;
                if(ans<j-nums[i])
                    ans=j-nums[i];
            }
        }
        return ans;
    }
}