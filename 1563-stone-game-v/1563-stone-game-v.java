class Solution {
    int[][] dp;
    int[] prefix;

    int rangeSum(int l, int r) {
        return prefix[r + 1] - prefix[l];
    }

    int solve(int l, int r) {
        // Only one stone
        if (l == r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int ans = 0;

        // Try every possible split
        for (int k = l; k < r; k++) {
            int left = rangeSum(l, k);
            int right = rangeSum(k + 1, r);

            if (left < right) {
                // Right is discarded
                ans = Math.max(ans, left + solve(l, k));
            } 
            else if (left > right) {
                // Left is discarded
                ans = Math.max(ans, right + solve(k + 1, r));
            } 
            else {
                // Alice can choose either side
                ans = Math.max(
                    ans,
                    left + Math.max(solve(l, k), solve(k + 1, r))
                );
            }
        }

        return dp[l][r] = ans;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sums
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score for subarray [l...r]
        dp = new int[n][n];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }

        return solve(0, n - 1);
    }
}
