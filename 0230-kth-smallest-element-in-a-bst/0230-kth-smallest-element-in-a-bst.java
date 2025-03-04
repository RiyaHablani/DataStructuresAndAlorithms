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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();
                maxHeap.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
                if(maxHeap.size()>k) maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}