
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        // Option 1: Buy only type 1 and type 2 items
        long option1 = (long) cost1 * need1
                     + (long) cost2 * need2;

        // Option 2: Buy type 3 for the common requirement,
        // then buy remaining individual items
        int common = Math.min(need1, need2);

        long option2 = (long) common * costBoth
                     + (long) (need1 - common) * cost1
                     + (long) (need2 - common) * cost2;

        // Option 3: Buy only type 3 items.
        // Extra contribution is allowed.
        long option3 = (long) Math.max(need1, need2) * costBoth;

        return Math.min(option1, Math.min(option2, option3));
    }
}
