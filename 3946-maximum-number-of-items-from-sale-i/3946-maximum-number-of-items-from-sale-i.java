class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];
            minPrice = Math.min(minPrice, price);
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    count++;
                }
            }
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + count
                );
            }
        }
        int ans = 0;
        for (int i = 0; i <= budget; i++) {
            int remaining = budget - i;
            int total = dp[i] + remaining / minPrice;
            ans = Math.max(ans, total);
        }
        return ans;
    }
}