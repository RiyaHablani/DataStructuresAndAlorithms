class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] p: prerequisites){
            int course=p[0];
            int prerequisite=p[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int completed=0;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            completed++;

            for(int neighbour:adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return completed==numCourses;
    }
}