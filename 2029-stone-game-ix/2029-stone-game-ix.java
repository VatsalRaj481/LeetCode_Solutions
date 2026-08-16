class Solution {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        for (int stone : stones) {
            int r = stone % 3;

            if (r == 0) {
                cnt0++;
            } else if (r == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        // If one of cnt1/cnt2 is zero, Alice has only one
        // possible non-zero remainder to start with.
        if (cnt1 == 0 || cnt2 == 0) {
            return Math.max(cnt1, cnt2) > 2 && cnt0 % 2 == 1;
        }

        // Both remainder types exist.
        if (cnt0 % 2 == 0) {
            return true;
        }

        return Math.abs(cnt1 - cnt2) > 2;
    }
}