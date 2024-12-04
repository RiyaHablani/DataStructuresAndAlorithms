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
    private int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return sum;
    }
    private int maxPathSumHelper(TreeNode root){
        if(root==null) return 0;
        int leftSum=Math.max(maxPathSumHelper(root.left),0);
        int rightSum=Math.max(maxPathSumHelper(root.right),0);
        sum=Math.max(sum,root.val+leftSum+rightSum);
        return root.val+Math.max(leftSum,rightSum);
    }
}