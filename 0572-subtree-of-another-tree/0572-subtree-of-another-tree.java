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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return t==null;
        }
        if(s.val==t.val && isSameTree(s,t)){
            return true;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t); 
    }
    private Boolean isSameTree(TreeNode s,TreeNode t){
        if(s==null){
            return t==null;
        }
        if(t==null){
            return false;
        }
        if(s.val!=t.val){
            return false;
        }
        return isSameTree(s.left,t.left) & isSameTree(s.right,t.right);
    }
}