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
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        helper(root);
        if(first!=null && last!=null){
            int temp =first.val;
            first.val=last.val;
            last.val=temp;
        }
        else if (first!=null && middle!=null){
            int temp=middle.val;
            middle.val=first.val;
            first.val=temp;
        }
        
    }
    private void helper(TreeNode root){
        if(root==null)
            return ;
        helper(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null && middle==null){
                first=prev;
                middle=root;
            }
            else
                last=root;
        }
        prev=root;
        helper(root.right);
    }
}