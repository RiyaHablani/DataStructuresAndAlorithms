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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEvenLevel = true; // Start with level 0 (even)

        while (!queue.isEmpty()) {
            int size = queue.size();
            int prevValue;

            // Expanded ternary operator
            if (isEvenLevel) {
                prevValue = Integer.MIN_VALUE;
            } else {
                prevValue = Integer.MAX_VALUE;
            }

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Check if value meets level constraints
                if (isEvenLevel && (current.val % 2 == 0 || current.val <= prevValue)) return false;
                if (!isEvenLevel && (current.val % 2 != 0 || current.val >= prevValue)) return false;

                prevValue = current.val;

                // Add child nodes to the queue
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            isEvenLevel = !isEvenLevel; // Toggle level type
        }

        return true;
    }
}