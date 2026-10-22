class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            // Case 1: Rotate left k times
            boolean sorted = true;
            for (int i = 0; i < n; i++) {
                if (nums[(k + i) % n] != i) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                int cost = Math.min(k, n - k + 2);
                ans = Math.min(ans, cost);
            }
            // Case 2: Rotate left k times, then reverse
            sorted = true;
            for (int i = 0; i < n; i++) {
                if (nums[(k + n - 1 - i) % n] != i) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                int cost = Math.min(k + 1, n - k + 1);
                ans = Math.min(ans, cost);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

