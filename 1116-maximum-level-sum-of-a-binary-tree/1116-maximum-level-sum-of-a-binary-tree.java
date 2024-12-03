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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return 0;
        int level=1;
        int maxLevel=0;
        int maxSum=Integer.MIN_VALUE;

        queue.offer(root);
        
        while(!queue.isEmpty()){
            int sum=0;
            int size=queue.size();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                sum+=queue.poll().val;
            }
            if(sum>maxSum){
                maxLevel=level;
                maxSum=sum;
            }
            level++;
        }
        return maxLevel;
    }
}