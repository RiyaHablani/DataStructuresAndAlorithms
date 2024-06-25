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
    private int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        bstToGstHelper(root);
        return root;
    }
    public TreeNode bstToGstHelper(TreeNode node){
        if(node==null){
            return null;
        }
        bstToGstHelper(node.right);
        sum+=node.val;
        node.val=sum;
        bstToGstHelper(node.left);
        return node;
    }
}