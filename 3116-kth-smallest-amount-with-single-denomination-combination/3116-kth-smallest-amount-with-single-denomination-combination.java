class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) coins[0] * k;

        // Remove duplicate denominations
        coins = java.util.Arrays.stream(coins).distinct().toArray();

        // The answer cannot exceed min(coins) * k
        long minCoin = Long.MAX_VALUE;
        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }
        high = minCoin * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;

        // Inclusion-exclusion over all subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean overflow = false;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // lcm(a,b) = a / gcd(a,b) * b
                    long value = lcm / g;

                    if (value > x / coins[i]) {
                        overflow = true;
                        break;
                    }

                    lcm = value * coins[i];
                }
            }

            if (overflow || lcm > x) {
                continue;
            }

            long multiples = x / lcm;

            if ((bits & 1) == 1) {
                result += multiples;
            } else {
                result -= multiples;
            }
        }

        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}