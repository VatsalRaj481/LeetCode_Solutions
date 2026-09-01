class Solution {
    static class State{
        int r,c;
        int energy;
        int mask;
        int moves;
        State(int r,int c,int energy,int mask,int moves){
            this.r=r;
            this.c=c;
            this.energy=energy;
            this.mask=mask;
            this.moves=moves;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        int[][] litterId = new int[m][n];
        for(int[] row:litterId){
            Arrays.fill(row,-1);
        }
        int startR=0,startC=0,litterCount=0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                char ch = classroom[r].charAt(c);
                if(ch=='S'){
                    startR=r;
                    startC=c;
                } 
                if(ch=='L'){
                    litterId[r][c]=litterCount++;
                }
            }
        }
        int allCollected = (1<<litterCount)-1;
        boolean[][][][] visited = new boolean[m][n][energy+1][1<<litterCount];

        Queue<State> queue = new ArrayDeque<>();
        visited[startR][startC][energy][0]=true;
        queue.offer(
            new State(
                startR,
                startC,
                energy,
                0,
                0
            )
        );
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        while(!queue.isEmpty()){
            State curr = queue.poll();
            if(curr.mask==allCollected){
                return curr.moves;
            }
            for(int d=0;d<4;d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];
                if(nr>=m || nc>=n || nr<0 || nc<0){
                    continue;
                }

                if(classroom[nr].charAt(nc)=='X')continue;

                if(curr.energy==0)continue;
                int newEnergy = curr.energy-1;
                int newMask = curr.mask;
                if(classroom[nr].charAt(nc)=='L'){
                    int id = litterId[nr][nc];
                    newMask |= (1<<id); 
                }

                if(classroom[nr].charAt(nc)=='R')newEnergy=energy;

                if(visited[nr][nc][newEnergy][newMask])continue;

                visited[nr][nc][newEnergy][newMask]=true;
                queue.offer(new State(
                    nr,
                    nc,
                    newEnergy,
                    newMask,
                    curr.moves+1
                ));

            }
        }
        return -1;
    }
}