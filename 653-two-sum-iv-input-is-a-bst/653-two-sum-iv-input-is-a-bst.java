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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    boolean reverse;
    BSTIterator(TreeNode root,boolean isReverse){
        reverse=isReverse;
        pushAll(root);
    }
    public int next(){
        TreeNode temp = stack.pop();
        if(reverse==false){
            pushAll(temp.right);
        }else{
            pushAll(temp.left);
        }
        return temp.val;
    }
    public boolean hasElement(){
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(reverse==true){
                root=root.right;
            }
            else {
                root=root.left;
            }     
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k)
                return true;
            if(i+j>k)
                j=r.next();
            else
                i=l.next();
        }
        return false;
    }
}