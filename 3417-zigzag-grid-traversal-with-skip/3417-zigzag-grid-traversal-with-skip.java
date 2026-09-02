class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        int m=grid.length,n=grid[0].length;
        boolean add=true;
        for(int i=0;i<m;i++){
            if(i%2==0){
                for(int j=0;j<n;j+=1){
                    if(add)result.add(grid[i][j]);
                    add=!add;
                }
            }
            else{
                for(int j=n-1;j>=0;j-=1){
                    if(add)result.add(grid[i][j]);
                    add=!add;
                }
            }
        }
        return result;
    }
}