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
    int sum=0;
    public int maxSumBST(TreeNode root) {
        if(root==null)
            return 0;
        ArrayList<Integer> res = maxSumBSTUtil(root);
        return sum;
    }
    private ArrayList<Integer> maxSumBSTUtil(TreeNode root){
        if(root==null)
            return new ArrayList<>(Arrays.asList(1,0,Integer.MAX_VALUE,Integer.MIN_VALUE));
        ArrayList<Integer> ltree = maxSumBSTUtil(root.left);
        ArrayList<Integer> rtree = maxSumBSTUtil(root.right);
        if(ltree.get(0)==1 && rtree.get(0)==1){
            if(ltree.get(3)<root.val && rtree.get(2)>root.val){
                sum=Math.max(sum,root.val+ltree.get(1)+rtree.get(1));
                return new ArrayList<>(Arrays.asList(1,root.val+ltree.get(1)+rtree.get(1),Math.min(ltree.get(2),root.val),Math.max(rtree.get(3),root.val)));
            }
        }
        return new ArrayList<>(Arrays.asList(0,Math.max(ltree.get(1),rtree.get(1)),Integer.MIN_VALUE,Integer.MAX_VALUE));
    }
}