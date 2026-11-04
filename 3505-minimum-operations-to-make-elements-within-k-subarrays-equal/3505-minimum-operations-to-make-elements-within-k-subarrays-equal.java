class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long sumLeft = 0;
    long sumRight = 0;
    int sizeLeft = 0;
    int sizeRight = 0;

    void addLeft(int num) {
        left.put(num, left.getOrDefault(num, 0) + 1);
        sumLeft += num;
        sizeLeft++;
    }

    void addRight(int num) {
        right.put(num, right.getOrDefault(num, 0) + 1);
        sumRight += num;
        sizeRight++;
    }

    void removeLeft(int num) {
        if (left.get(num) == 1) {
            left.remove(num);
        } else {
            left.put(num, left.get(num) - 1);
        }
        sumLeft -= num;
        sizeLeft--;
    }

    void removeRight(int num) {
        if (right.get(num) == 1) {
            right.remove(num);
        } else {
            right.put(num, right.get(num) - 1);
        }
        sumRight -= num;
        sizeRight--;
    }

    int getMedian() {
        return left.lastKey();
    }

    void balance() {
        while (sizeLeft > sizeRight + 1) {
            int val = left.lastKey();
            removeLeft(val);
            addRight(val);
        }

        while (sizeLeft < sizeRight) {
            int val = right.firstKey();
            removeRight(val);
            addLeft(val);
        }

        while (!left.isEmpty() && !right.isEmpty()
                && left.lastKey() > right.firstKey()) {
            int a = left.lastKey();
            int b = right.firstKey();

            removeLeft(a);
            removeRight(b);

            addLeft(b);
            addRight(a);
        }
    }

    void add(int num) {
        if (left.isEmpty() || num <= left.lastKey()) {
            addLeft(num);
        } else {
            addRight(num);
        }
        balance();
    }

    void remove(int num) {
        if (left.containsKey(num)) {
            removeLeft(num);
        } else {
            removeRight(num);
        }
        balance();
    }

    long getCost() {
        long median = getMedian();

        return median * sizeLeft - sumLeft
                + sumRight - median * sizeRight;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        if (k == 0) return 0;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select a window ending at i - 1
                if (i >= x && dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
