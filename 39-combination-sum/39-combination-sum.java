class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationUtil(candidates,target,0,res,temp);
        return res;
    }
    private void combinationUtil(int[] candidates,int target,int start,List<List<Integer>> res,List<Integer> temp){
        if(target<0)
            return;
        else if(target==0){
            res.add(new ArrayList<>(temp));
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            combinationUtil(candidates,target-candidates[i],i,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}