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
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int res[] = robHelper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] robHelper(TreeNode root) {
        if(root==null)
            return new int[2];
        int ltree[]=robHelper(root.left);
        int rtree[]=robHelper(root.right);
        int res[] = new int[2];
        res[0]=Math.max(ltree[0],ltree[1])+Math.max(rtree[0],rtree[1]);
        res[1]=root.val+ltree[0]+rtree[0];
        return res;
    }
}