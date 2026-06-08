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
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean isEven=true;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            int prev=(isEven)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();
                if((isEven && (currentNode.val%2==0 || currentNode.val<=prev)) || 
                (!isEven && (currentNode.val%2!=0 || currentNode.val>=prev))){
                    return false;
                }
                prev=currentNode.val;
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
            }
            isEven=!isEven;
        }
        return true;
    }
}