class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];

        for(int[] pair:prerequisites){
            int course=pair[0];
            int prerequisite=pair[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int arr[]=new int[numCourses];
        int j=0;

        while(!queue.isEmpty()){
            int node=queue.poll();
            arr[j]=node;
            j++;

            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return j == numCourses ? arr : new int[0];
    }
}