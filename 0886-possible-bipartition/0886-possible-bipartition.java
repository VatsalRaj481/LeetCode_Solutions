class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:dislikes){
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] color = new int[n+1];
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                color[i]=1;
                if(!dfs(i,graph,color)){
                    return false;
                }
            }

        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> graph, int[] color){
        for(int neighbour:graph.get(node)){
            if(color[neighbour]==0){
                color[neighbour]=3-color[node];
                if(!dfs(neighbour,graph,color)) return false;
            }
            else if(color[neighbour]==color[node]){
                return false;
            }
        }
        return true;
    }
}