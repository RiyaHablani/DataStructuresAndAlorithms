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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calculateSum(root);
        return maxSum;
    }
    public int calculateSum(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftSum=Math.max(calculateSum(node.left),0);
        int rightSum=Math.max(calculateSum(node.right),0);
        maxSum=Math.max(maxSum,node.val+leftSum+rightSum);
        return node.val+Math.max(leftSum,rightSum);
    }
}