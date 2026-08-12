class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal==0){
            return true;
        }
        int totalSum = maxChoosableInteger*(maxChoosableInteger+1)/2;
        if(totalSum<desiredTotal)return false;
        int[] memo = new int[1<<maxChoosableInteger];
        return dfs(0,0,maxChoosableInteger,desiredTotal,memo);
    }
    private boolean dfs(int mask,int currentTotal,int max,int target,int[] memo){
        if(memo[mask]!=0){
            return memo[mask]==1;
        }
        for(int i=1;i<=max;i++){
            int bit = 1<<(i-1);
            if((mask & bit)!=0)continue;
            if(currentTotal+i>=target){
                memo[mask]=1;
                return true;
            }
            if(!dfs(mask|bit,currentTotal+i,max,target,memo)){
                memo[mask]=1;
                return true;
            }
        }
        memo[mask]=-1;
        return false;
    }
}