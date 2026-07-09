class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map = new HashMap<>();
        for(int[] row:grid){
            String key = Arrays.toString(row);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int ans=0,n=grid.length;
        for(int c=0;c<n;c++){
            int[] col = new int[n];
            for(int r=0;r<n;r++){
                col[r]=grid[r][c];
            } 
            String column = Arrays.toString(col);
            ans+=map.getOrDefault(column,0);
        }
        return ans;
    }
}