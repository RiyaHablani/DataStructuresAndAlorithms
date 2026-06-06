class Solution {
    class NodeInfo {
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // column -> row -> list of values
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map =
                new TreeMap<>();
        Queue<NodeInfo> q = new LinkedList<>();
        // root is at row = 0, col = 0
        q.offer(new NodeInfo(root, 0, 0));
        while (!q.isEmpty()) {
            NodeInfo curr = q.poll();
            // If column does not exist, create it
            if (!map.containsKey(curr.col)) {
                map.put(curr.col, new TreeMap<>());
            }
            // If row does not exist in that column, create it
            if (!map.get(curr.col).containsKey(curr.row)) {
                map.get(curr.col).put(curr.row, new ArrayList<>());
            }
            // Add current node value
            map.get(curr.col).get(curr.row).add(curr.node.val);
            // Left child: row + 1, col - 1
            if (curr.node.left != null) {
                q.offer(new NodeInfo(
                        curr.node.left,
                        curr.row + 1,
                        curr.col - 1
                ));
            }

            // Right child: row + 1, col + 1
            if (curr.node.right != null) {
                q.offer(new NodeInfo(
                        curr.node.right,
                        curr.row + 1,
                        curr.col + 1
                ));
            }
        }
        // Traverse columns from left to right
        for (TreeMap<Integer, List<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            // Traverse rows from top to bottom
            for (List<Integer> list : rows.values()) {
                // Sort values if same row and same column
                Collections.sort(list);
                colList.addAll(list);
            }
            res.add(colList);
        }
        return res;
    }
}