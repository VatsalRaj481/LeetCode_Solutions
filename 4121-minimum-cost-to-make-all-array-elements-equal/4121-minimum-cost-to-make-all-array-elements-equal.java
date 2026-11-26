class Solution {
    public long minCost(int[] nums) {
        int n = nums.length, i = 0;
        long ans = Long.MAX_VALUE;
        while (i < n) {
            int j = i;
            while (j < n && nums[i] == nums[j]) {
                j++;
            }
            int len = j - i;
            if (i < n - 1 && j > 1) {
                long cost = (long) nums[i] * (n - len);
                ans = Math.min(ans, cost);
            }
            i = j;
        }
        return ans;
    }
}