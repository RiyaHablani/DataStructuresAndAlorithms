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
    String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return smallest;
    }

    private void dfs(TreeNode root, String curr) {
        if (root == null) return;

        curr = (char)(root.val + 'a') + curr;

        if (root.left == null && root.right == null) {
            if (smallest == null || curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            return;
        }

        dfs(root.left, curr);
        dfs(root.right, curr);
    }
}