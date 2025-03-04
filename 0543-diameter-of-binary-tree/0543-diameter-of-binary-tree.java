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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }
    public int calculateDiameter(TreeNode root){
        if(root==null) return 0;
        int leftHeight=calculateDiameter(root.left);
        int rightHeight=calculateDiameter(root.right);
        diameter=Math.max(diameter,leftHeight+rightHeight);
 
        return Math.max(leftHeight,rightHeight)+1;
    }
}