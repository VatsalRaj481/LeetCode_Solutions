class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
       List<Integer>[] graph = new ArrayList[n];
       for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
       }
       for(int[] edge:edges){
        int u =edge[0],v=edge[1];
        graph[u].add(v);
        graph[v].add(u); 
       } 

       boolean[] visited = new boolean[n];
       int ans=0;
       for(int i=0;i<n;i++){
        if(!visited[i]){
            List<Integer> component = new ArrayList<>();
            dfs(i,graph,visited,component);
            int size = component.size();
            boolean isComplete=true;
            for(int node:component){
                if(graph[node].size()!=size-1){
                    isComplete=false;
                    break;
                }
            }
            if(isComplete){
                ans++;
            }
        }
       }
       return ans;
    }

    private void dfs(int node,List<Integer>[] graph,boolean[] visited,List<Integer> component){
        visited[node]=true;
        component.add(node);
        for(int neighbour: graph[node]){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited,component);
            }
        }
    }
}