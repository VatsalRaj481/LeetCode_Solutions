// class Solution {
//     public int tribonacci(int n) {
//         if(n==0)return 0;
//         if(n==1||n==2)return 1;
//         int a=0,b=1,c=1;
//         for(int i=3;i<=n;i++){
//             int next = a+b+c;
//             a=b;
//             b=c;
//             c=next;
//         }
//         return c;
//     }
// }

class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    private int solve(int n,int[] dp){
        if(n==0)return 0;
        if(n==1||n==2)return 1;

        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]= solve(n-1,dp)+
               solve(n-2,dp)+
               solve(n-3,dp);

        return dp[n];
    }
}