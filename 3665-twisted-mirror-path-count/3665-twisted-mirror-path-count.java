class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        if (m == 1 && n == 1) {
            return 1;
        }
        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        // Robot starts at (0, 0).
        // The starting cell is not entered, so its mirror
        // does not trigger a reflection.
        if (n > 1) {
            right[0][1] = 1;
        }
        if (m > 1) {
            down[1][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long r = right[i][j];
                long d = down[i][j];
                // Destination reached.
                if (i == m - 1 && j == n - 1) {
                    return (int) ((r + d) % MOD);
                }
                if (grid[i][j] == 1) {
                    // Mirror:
                    // Moving right -> turn down.
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + r) % MOD;
                    }
                    // Moving down -> turn right.
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + d) % MOD;
                    }
                } else {
                    // Empty cell: can move right or down.
                    long ways = (r + d) % MOD;
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + ways) % MOD;
                    }
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + ways) % MOD;
                    }
                }
            }
        }
        return 0;
    }
}
