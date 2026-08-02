//Brute Force
// class Solution {
//     public boolean stoneGame(int[] piles) {
//         return recurse(piles, 0, piles.length - 1, 0, 0, true);
//     }
//     private boolean recurse(int[] piles, int left, int right,
//                             int alice, int bob, boolean aliceTurn) {
//         if (left > right) {
//             return alice > bob;
//         }
//         if (aliceTurn) {
//             return recurse(piles, left + 1, right,
//                            alice + piles[left], bob, false)
//                 || recurse(piles, left, right - 1,
//                            alice + piles[right], bob, false);
//         } else {
//             return recurse(piles, left + 1, right,
//                            alice, bob + piles[left], true)
//                 && recurse(piles, left, right - 1,
//                            alice, bob + piles[right], true);
//         }
//     }
// }

class Solution {
    private Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve(piles,0,n-1)>0;
    }
    private int solve(int[] piles,int left,int right){
        if(left==right){
            return piles[left];
        }
        if(dp[left][right]!=null){
            return dp[left][right];
        }
        int takeLeft = piles[left]-solve(piles,left+1,right);
        int takeRight = piles[right]-solve(piles,left,right-1);
        return dp[left][right]=Math.max(takeLeft,takeRight);
    }
}