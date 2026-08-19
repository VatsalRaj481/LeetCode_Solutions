class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int liveNeighbours=0;
                for(int[] dir:directions){
                    int ni=i+dir[0];
                    int nj=j+dir[1];

                    if(ni>=0 && ni<m && nj>=0 && nj<n){
                        liveNeighbours+=board[ni][nj]%2;
                    }
                }
                //original state
                int current = board[i][j]%2;
                if(current==1){
                    if(liveNeighbours==2 || liveNeighbours==3){
                        board[i][j]=3;
                    }
                    else{
                        board[i][j]=1;
                    }
                }
                else{
                    if(liveNeighbours==3){
                        board[i][j]=2;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]/=2;
            }
        }
    }
}

/*
0 = dead → dead
1 = alive → alive
2 = dead → alive
3 = alive → dead
*/