class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        StringBuilder firstRow = new StringBuilder();
        for(int j=0;j<n;j++){
            firstRow.append('.');
        }
        StringBuilder otherRows = new StringBuilder();
        for(int j=0;j<n-1;j++){
            otherRows.append('#');
        }
        otherRows.append('.');
        grid[0]=firstRow.toString();
        for(int i=1;i<m;i++){
            grid[i]=otherRows.toString();
        }
        return grid;
    }
}