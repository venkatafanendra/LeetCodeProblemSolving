class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUtil(res,temp,nums,used);
        return res;
    }
    private void permuteUtil(List<List<Integer>> res,List<Integer> temp,int[] nums,boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        } else {
            for(int i=0;i<nums.length;i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])
                    continue;
                used[i]=true;
                temp.add(nums[i]);
                permuteUtil(res,temp,nums,used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}