class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] edge:prerequisites){
            int pre=edge[1];
            int course=edge[0];
            graph.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int completed=0;
        while(!queue.isEmpty()){
            int course =queue.poll();
            completed++;
            for(int next:graph.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
        }

        return completed==numCourses;
    }
}