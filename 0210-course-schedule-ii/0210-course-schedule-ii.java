class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
       }

       int[] indegree = new int[numCourses];

       for(int[] edge:prerequisites){
        int pre=edge[1],course=edge[0];
        graph.get(pre).add(course);
        indegree[course]++;
       }

       Queue<Integer> queue = new ArrayDeque<>();
       int[] order = new int[numCourses];
       int j=0;

       for(int i=0;i<numCourses;i++){
        if(indegree[i]==0){
            queue.offer(i);
        }
       }
       while (!queue.isEmpty()){
            int course = queue.poll();
            order[j++]=course;
            for(int next:graph.get(course)){
                indegree[next]--;
                if(indegree[next]==0){
                    queue.offer(next);
                }
            }
       }

       if(j==numCourses){
            return order;
       }
       else{
        return new int[] {};
       }
    }
}