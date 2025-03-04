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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        queue.offer(root);
        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();
                list.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            if (!leftToRight) Collections.reverse(list);
            result.add(list);
            leftToRight = !leftToRight;
        }
        return result;
    }
}