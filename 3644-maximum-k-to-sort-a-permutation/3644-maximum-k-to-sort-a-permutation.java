class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        boolean sorted = true;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                sorted = false;
                ans &= nums[i] & i;
            }
        }

        return sorted ? 0 : ans;
    }
}