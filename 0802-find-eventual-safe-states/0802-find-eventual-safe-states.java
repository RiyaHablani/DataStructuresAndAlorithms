class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        
        List<List<Integer>> reverse=new ArrayList<>();
        for(int i=0;i<n;i++){
            reverse.add(new ArrayList<>());
        }
        int[] outdegree=new int[n];

        for(int i=0;i<n;i++){
            outdegree[i]=graph[i].length;

            for(int neighbour:graph[i]){
                reverse.get(neighbour).add(i);
            }
        }
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(outdegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> safe = new ArrayList<>();

        while(!queue.isEmpty()){
            int node=queue.poll();
            safe.add(node);

            for(int neighbour:reverse.get(node)){
                outdegree[neighbour]--;
                if(outdegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}