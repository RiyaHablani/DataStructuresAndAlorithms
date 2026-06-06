class Solution {
    class NodeInfo{
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> map=new TreeMap<>();
        Queue<NodeInfo> q=new LinkedList<>();
        q.offer(new NodeInfo(root, 0, 0));
        while(!q.isEmpty()){
            NodeInfo curr=q.poll();
            if(!map.containsKey(curr.col)){
                map.put(curr.col,new TreeMap<>());
            }
            if(!map.get(curr.col).containsKey(curr.row)){
                map.get(curr.col).put(curr.row,new ArrayList<>());
            }
            map.get(curr.col).get(curr.row).add(curr.node.val);

            if(curr.node.left!=null){
                q.offer(new NodeInfo(curr.node.left,curr.row+1,curr.col-1));
            }
            if(curr.node.right!=null){
                q.offer(new NodeInfo(curr.node.right,curr.row+1,curr.col+1));
            }
        }
        for(TreeMap<Integer,List<Integer>> rows:map.values()){
            List<Integer> colList=new ArrayList<>();
            for (List<Integer> list : rows.values()) {
                Collections.sort(list);
                colList.addAll(list);
            }
            res.add(colList);
        }
        return res;
    }
}