class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // To track the zigzag order

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    list.add(node.val); // Add values in left-to-right order
                } else {
                    list.add(0, node.val); // Add values in reverse order
                }

                // Add child nodes to the queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // Add the current level to the result
            result.add(list);

            // Toggle the direction for the next level
            leftToRight = !leftToRight;
        }
        return result;
    }
}
