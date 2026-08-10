class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = quiet.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:richer){
            int rich = edge[0], poor = edge[1];
            graph.get(poor).add(rich);
        }
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            dfs(i,graph,quiet,ans);
        }
        return ans;
    }

    private int dfs(int node,List<List<Integer>> graph, int[] quiet, int[] ans){
        if(ans[node]!=-1){
            return ans[node];
        }
        ans[node]=node;
        for(int richer:graph.get(node)){
            int candidate = dfs(richer,graph,quiet,ans);
            if(quiet[candidate]<quiet[ans[node]]){
                ans[node]=candidate;
            }
        }
        return ans[node];
    }
}