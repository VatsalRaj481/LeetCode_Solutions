class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],-1);
        }
        int start = health - grid.get(0).get(0);
        if(start<=0){
            return false;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2]-a[2]);
        pq.offer(new int[]{0,0,start});
        dist[0][0]=start;
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r=cur[0];
            int c=cur[1];
            int h=cur[2];
            if(r==m-1 && c==n-1) return true;
            if(h<dist[r][c])continue;

            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr<0 || nr>=m|| nc<0 || nc>=n )continue;
                int nh = h-grid.get(nr).get(nc);
                if(nh>0 && nh>dist[nr][nc]){
                    dist[nr][nc]=nh;
                    pq.offer(new int[]{nr,nc,nh});
                }
            }
        }
        return false;
    }
}