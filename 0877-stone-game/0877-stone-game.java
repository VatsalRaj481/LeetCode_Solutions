class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // Base case: one pile
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Build solutions for larger intervals
        for (int len = 2; len <= n; len++) {
            for (int left = 0; left + len - 1 < n; left++) {
                int right = left + len - 1;
                int takeLeft = piles[left] - dp[left + 1][right];
                int takeRight = piles[right] - dp[left][right - 1];
                dp[left][right] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n - 1] > 0;
    }
}

// Brute Force
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