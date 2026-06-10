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
    String smallest = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        char ch = (char)(root.val + 'a');
        sb.insert(0, ch);
        if (root.left == null && root.right == null) {
            String curr = sb.toString();
            if (smallest.equals("") || curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(0);
    }
}