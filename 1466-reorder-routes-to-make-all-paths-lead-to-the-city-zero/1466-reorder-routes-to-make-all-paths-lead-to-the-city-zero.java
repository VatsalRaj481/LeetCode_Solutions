/*
***
DFS moves away from 0. Any original road moving in the same direction as DFS is wrong and must be reversed.

***
*/
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] connection:connections){
            int a=connection[0],b=connection[1];
            graph.get(a).add(new int[]{b,1});
            graph.get(b).add(new int[]{a,0});
        }
        boolean[] visited = new boolean[n];
        return dfs(0,graph,visited);
    }

    private int dfs(int city,List<List<int[]>> graph,boolean[] visited){
        visited[city]=true;
        int count=0;
        for(int[] edge:graph.get(city)){
            int neighbour = edge[0];
            int cost = edge[1];

            if(!visited[neighbour]){
                count+=cost;
                count+=dfs(neighbour,graph,visited);
            }
        }
        return count;
    }
}