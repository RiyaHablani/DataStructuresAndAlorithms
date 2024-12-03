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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode[] nodes = new TreeNode[size]; // Store nodes of the current level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                nodes[i] = current; // Save nodes at this level
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            // Reverse values at odd levels
            if (level % 2 != 0) {
                int left = 0, right = size - 1;
                while (left < right) {
                    int temp = nodes[left].val;
                    nodes[left].val = nodes[right].val;
                    nodes[right].val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}