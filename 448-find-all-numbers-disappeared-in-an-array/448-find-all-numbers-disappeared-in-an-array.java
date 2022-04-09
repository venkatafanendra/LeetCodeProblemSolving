class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int counter[] = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            counter[nums[i]-1]++;
        }
        for(int i=0;i<counter.length;i++){
            if(counter[i]==0)
                result.add(i+1);
        }
        return result;
    }
}