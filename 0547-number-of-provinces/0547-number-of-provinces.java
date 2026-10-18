class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        boolean[] visited=new boolean[V];
        int count=0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node,int[][] isConnected,boolean[] visited){
        visited[node]=true;
        for(int neighbour=0;neighbour<isConnected.length;neighbour++){
            if(isConnected[node][neighbour]==1 && !visited[neighbour]){
                dfs(neighbour,isConnected,visited);
            }
        }
    }
}