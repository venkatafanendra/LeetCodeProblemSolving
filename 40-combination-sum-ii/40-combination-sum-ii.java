class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Util(candidates,target,res,temp,0);
        return res;
    }
    private void combinationSum2Util(int[] candidates,int target,List<List<Integer>> res,List<Integer> temp,int start) {
        if(target<0)
            return ;
        else if(target==0)
            res.add(new ArrayList<>(temp));
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            temp.add(candidates[i]);
            combinationSum2Util(candidates,target-candidates[i],res,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}