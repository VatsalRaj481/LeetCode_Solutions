import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        long[] divisible = new long[max + 1];

        // Count numbers divisible by every i
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                divisible[i] += freq[j];
            }
        }

        long[] exact = new long[max + 1];

        // Inclusion-Exclusion
        for (int g = max; g >= 1; g--) {
            long cnt = divisible[g];
            long pairs = cnt * (cnt - 1) / 2;

            for (int multiple = g + g; multiple <= max; multiple += g) {
                pairs -= exact[multiple];
            }

            exact[g] = pairs;
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i];

            int left = 1, right = max;
            while (left < right) {
                int mid = (left + right) / 2;

                if (prefix[mid] > k)
                    right = mid;
                else
                    left = mid + 1;
            }

            ans[i] = left;
        }

        return ans;
    }
}