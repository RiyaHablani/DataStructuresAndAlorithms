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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        // hash the values with index
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = preorder.length - 1;
        int m = inorder.length - 1;
        TreeNode root = constructTree(preorder, inorder, indexMap, 0, n, 0, m);
        return root;
    }

    public TreeNode constructTree(int[] preorder, int[] inorder,
            HashMap<Integer, Integer> indexMap, int preIndStart, int preIndEnd,
            int inIndStart, int inIndEnd) {
        // handle the base case
        if (preIndStart > preIndEnd || inIndStart > inIndEnd) {
            return null;
        }
        int rootData = preorder[preIndStart];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int leftTreeSize = rootIndex - inIndStart;
        int rightTreeSize = inIndEnd - rootIndex;
        root.left = constructTree(preorder, inorder, indexMap, preIndStart+1,
                preIndStart + leftTreeSize , inIndStart, rootIndex - 1);
        root.right = constructTree(preorder, inorder, indexMap, preIndStart + leftTreeSize+1, preIndStart + leftTreeSize+ rightTreeSize,
                rootIndex + 1, inIndEnd);
        return root;
    }
}