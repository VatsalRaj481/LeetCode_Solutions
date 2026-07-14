class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] directions={
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
        };
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(
            new int[]{
                entrance[0],
                entrance[1]
            }
        );
        maze[entrance[0]][entrance[1]]='+';
        int steps=0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for(int[] dir:directions){
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if(newRow<0 || newRow>=m || newCol<0 || newCol>=n){
                            continue;
                    }

                    if(maze[newRow][newCol]=='+'){
                        continue;
                    }

                    if(newRow==0 || newRow==m-1 ||newCol==0 || newCol==n-1){
                        return steps+1;
                    }
                    maze[newRow][newCol]='+';
                    queue.offer(new int[]{newRow,newCol});
                }
            }
            steps++;
        }
        return -1;
    }
}