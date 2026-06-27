class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int x : nums)
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        int ans = 1;
        for (int x : mp.keySet()) {
            if (x == 1) {
                int f = mp.get(1);
                ans = Math.max(ans, (f % 2 == 0) ? f - 1 : f);
            } else {
                if (mp.get(x) < 2)
                    continue;
                int ct = 0;
                long curr = x;
                while (curr <= Integer.MAX_VALUE && mp.containsKey((int) curr)) {
                    ct++;
                    if (mp.get((int) curr) == 1)
                        break;
                    if (curr > Long.MAX_VALUE / curr)
                        break;
                    curr *= curr;
                }
                ans = Math.max(ans, 2 * ct - 1);
            }
        }
        return ans;
    }
}