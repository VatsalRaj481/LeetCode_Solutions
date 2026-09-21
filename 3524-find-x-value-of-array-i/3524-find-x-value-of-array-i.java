class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            long[] next = new long[k];
            int rem = num % k;
            // Case 1: Start a new subarray
            next[rem]++;
            // Case 2: Extend previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRem = (int) ((long) r * rem % k);
                    next[newRem] += dp[r];
                }
            }
            // Update the final result
            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }
            // Move to the next index
            dp = next;
        }
        return result;
    }
}