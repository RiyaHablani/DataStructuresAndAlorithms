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
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentNode=queue.poll();
                list.add(currentNode.val);
                if(!list.isEmpty() && list.size()>1 && level%2==0){
                    if(list.get(i-1)>=list.get(i)){
                        return false;
                    }
                }if(!list.isEmpty() && list.size()>1 && level%2!=0){
                    if(list.get(i)>=list.get(i-1)){
                        return false;
                    }
                }
                if(level%2==0 && list.get(i)%2==0){
                    return false;
                }
                if(level%2!=0 && list.get(i)%2!=0){
                    return false;
                }
                if(currentNode.left!=null) queue.offer(currentNode.left);
                if(currentNode.right!=null) queue.offer(currentNode.right);
            }
            level++;
        }
        return true;
    }
}