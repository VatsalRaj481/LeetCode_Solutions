class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n =grid[0].length;
        if((m+n-1)%2!=0)return false;
        if(grid[0][0]==')')return false;
        boolean[][][] dp = new boolean[m][n][m+n];
        dp[0][0][1]=true;
        int[] di={0,1};
        int[] dj={1,0};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==m-1 && j==n-1)continue;
                for(int balance=0;balance<m+n;balance++){
                    if(!dp[i][j][balance])continue;
                    for(int d=0;d<2;d++){
                        int newI = i+di[d];
                        int newJ = j+dj[d];
                        if(newI<0 || newI>=m || newJ<0 ||newJ>=n)continue;
                        int newBalance;
                        if(grid[newI][newJ]=='(')newBalance=balance+1;
                        else newBalance=balance-1;
                        if(newBalance>=0){
                            dp[newI][newJ][newBalance]=true;
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}