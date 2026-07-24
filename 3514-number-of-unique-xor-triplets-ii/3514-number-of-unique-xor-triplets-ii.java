class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        boolean[] triplet = new boolean[2048];

        int n = nums.length;

        // All possible pair XORs (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        // Combine each pair XOR with every element
        for (int x = 0; x < 2048; x++) {
            if (!pair[x]) continue;

            for (int num : nums) {
                triplet[x ^ num] = true;
            }
        }

        int ans = 0;
        for (boolean b : triplet) {
            if (b) ans++;
        }

        return ans;
    }
}