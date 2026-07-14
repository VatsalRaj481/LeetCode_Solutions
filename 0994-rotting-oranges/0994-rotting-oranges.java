class Solution {
    public int orangesRotting(int[][] grid) {
        int m  =grid.length;
        int n = grid[0].length;
        int minutes=0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            for(int i=0;i<size;i++){

                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(int[] dir:directions){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow<0||newCol<0||newRow>=m||newCol>=n){
                        continue;
                    }
                    if(grid[newRow][newCol]==2||grid[newRow][newCol]==0){
                        continue;
                    }
                    else{
                        grid[newRow][newCol]=2;
                        rotted=true;
                        queue.offer(new int[] {newRow,newCol});
                    }
                }
            }
            if(rotted){
            minutes++;
            }
        } 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return Math.max(minutes,0);
    }
}