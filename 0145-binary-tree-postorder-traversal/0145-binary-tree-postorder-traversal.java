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
    public List<Integer> postorderTraversal(TreeNode root) { 
        // This will store the final postorder result
        // Postorder = Left -> Right -> Root
        List<Integer> res = new ArrayList<Integer>(); 
        // Stack is used to remember the nodes
        // whose children are still not completely processed
        Stack<TreeNode> stack = new Stack<>(); 
        // Start from the root
        TreeNode node = root; 
        // Continue while we have a node to visit
        // OR there are nodes waiting in the stack
        while (node != null || !stack.isEmpty()) { 
            // First, keep going to the left
            if (node != null) { 
                // Store the current node in stack
                stack.push(node); 
                // Move to left child
                node = node.left; 
            } 
            // We have reached the end of the left side
            // Now check if the top node has a right child
            else if (stack.peek().right != null) { 
                // Move to the right subtree
                node = stack.peek().right; 
            } 
            // No left child and no right child
            // So we can process the current node
            else { 
                // Remove node from stack
                TreeNode temp = stack.pop(); 
                // Add it to result
                // Both left and right sides are done
                res.add(temp.val); 
                // Check if this processed node was the
                // RIGHT child of the node above it
                while (!stack.isEmpty() && temp == stack.peek().right) { 
                    // If yes, the parent is also ready
                    // because its left and right are completed
                    temp = stack.pop(); 
                    // Add parent to result
                    res.add(temp.val); 
                } 
            } 
        } 
        return res; 
    } 
}