class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        long total = 0;

        //Computing total
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total+=grid[i][j];
            }
        }

        //if total is odd, can't split equally
        if(total%2!=0)return false;

        long target = total/2;

        //Check horizontal cuts
        long curr = 0;
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                curr+=grid[i][j];
            }
            if(curr==target)return true;
        }

        //Computing colummn sums
        long[] colSum = new long[n];
        for(int j=0;j<n-1;j++){
            colSum[j]=0;
            for(int i=0;i<m;i++){
                colSum[j]+=grid[i][j];
            }
        }

        //Checking vertival cuts
        curr=0;
        for(int j=0;j<n-1;j++){
            curr+=colSum[j];
            if(curr==target)return true;
        }
        return false;
    }
}