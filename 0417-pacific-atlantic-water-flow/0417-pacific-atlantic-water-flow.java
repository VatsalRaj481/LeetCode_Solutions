class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int c=0;c<n;c++){
            dfs(0,c,pacific,heights);
        }
        for(int r=0;r<m;r++){
            dfs(r,0,pacific,heights);
        }
        for(int c=0;c<n;c++){
            dfs(m-1,c,atlantic,heights);
        }
        for(int r=0;r<m;r++){
            dfs(r,n-1,atlantic,heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(atlantic[r][c] && pacific[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }
    private void dfs(int r,int c,boolean[][] visited,int[][] heights){
        if(visited[r][c])return;
        visited[r][c]=true;
        int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };
        for(int[] dir:directions){
            int nr = r+dir[0];
            int nc=c+dir[1];
            if(nr>=0 && nr<heights.length 
              && nc>=0 && nc<heights[0].length 
              && !visited[nr][nc] 
              && heights[nr][nc]>=heights[r][c]){
                dfs(nr,nc,visited,heights);
              }
        }
    }
}