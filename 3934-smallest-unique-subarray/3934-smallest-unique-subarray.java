class Solution {

    static final long MOD1 = 1000000007L;
    static final long MOD2 = 1000000009L;
    static final long BASE = 911382323L;

    static class HashKey {
        long h1, h2;

        HashKey(long h1, long h2) {
            this.h1 = h1;
            this.h2 = h2;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof HashKey)) return false;

            HashKey other = (HashKey) obj;

            return h1 == other.h1 && h2 == other.h2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(h1, h2);
        }
    }

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];

        pow1[0] = 1;
        pow2[0] = 1;

        // Build prefix hashes and powers
        for (int i = 0; i < n; i++) {

            long val1 = ((long) nums[i] % MOD1 + MOD1) % MOD1;
            long val2 = ((long) nums[i] % MOD2 + MOD2) % MOD2;

            pref1[i + 1] =
                (pref1[i] * BASE + val1 + 1) % MOD1;

            pref2[i + 1] =
                (pref2[i] * BASE + val2 + 1) % MOD2;

            pow1[i + 1] = pow1[i] * BASE % MOD1;
            pow2[i + 1] = pow2[i] * BASE % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (existsUnique(mid, n, pref1, pref2,
                             pow1, pow2)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean existsUnique(
        int len,
        int n,
        long[] pref1,
        long[] pref2,
        long[] pow1,
        long[] pow2
    ) {

        HashMap<HashKey, Integer> map = new HashMap<>();

        // Calculate frequency of every window
        for (int i = 0; i + len <= n; i++) {

            int j = i + len;

            long h1 = (
                pref1[j] -
                pref1[i] * pow1[len] % MOD1 +
                MOD1
            ) % MOD1;

            long h2 = (
                pref2[j] -
                pref2[i] * pow2[len] % MOD2 +
                MOD2
            ) % MOD2;

            HashKey key = new HashKey(h1, h2);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check whether any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
