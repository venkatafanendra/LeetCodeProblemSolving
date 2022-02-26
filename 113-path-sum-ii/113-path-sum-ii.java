/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        List<Integer> fr = new ArrayList<>();
        getAllLeafs(root,targetSum,res,0,fr);
        return res;
    }
    public void getAllLeafs(TreeNode root,int targetSum,List<List<Integer>> res,int len,List<Integer> fr){
        if(root==null)
            return;
        fr.add(root.val);
        len++;
        int reqsum = targetSum - root.val;
        if(root.left == null && root.right == null && targetSum == root.val)
            addres(res,fr,len);
        getAllLeafs(root.left,reqsum,res,len,fr);
        getAllLeafs(root.right,reqsum,res,len,fr);
        fr.remove(fr.size()-1);
        }
    public void addres(List<List<Integer>> res,List<Integer> free,int len){
        List<Integer> fr = new ArrayList<>();
        for(int i=0;i<len;i++){
            fr.add(free.get(i));
        }
        res.add(fr);
    }
}