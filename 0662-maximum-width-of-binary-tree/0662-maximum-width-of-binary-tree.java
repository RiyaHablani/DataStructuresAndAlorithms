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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0)); // Pair of node and its index

        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstIndex = queue.peek().index; // First node's index at the current level
            int lastIndex = firstIndex; // Initialize the last index

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 1));
                }

                lastIndex = index; // Update the last index with the current node's index
            }
            // Calculate the width: last index - first index + 1
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }
}
    // Helper class to store the node and its index
    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
    }
}