
class Solution {

    class SegmentTree {
        long[] sum;
        int[] max;
        int[] lazy;
        boolean[] hasLazy;
        int n;

        SegmentTree(int[] nums) {
            n = nums.length;

            sum = new long[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
            hasLazy = new boolean[4 * n];

            build(1, 0, n - 1, nums);
        }

        void build(int node, int l, int r, int[] nums) {
            if (l == r) {
                sum[node] = nums[l];
                max[node] = nums[l];
                return;
            }

            int mid = (l + r) / 2;

            build(node * 2, l, mid, nums);
            build(node * 2 + 1, mid + 1, r, nums);

            pull(node);
        }

        void pull(int node) {
            sum[node] = sum[node * 2] + sum[node * 2 + 1];
            max[node] = Math.max(max[node * 2],
                                 max[node * 2 + 1]);
        }

        void apply(int node, int l, int r, int val) {
            sum[node] = (long) (r - l + 1) * val;
            max[node] = val;
            lazy[node] = val;
            hasLazy[node] = true;
        }

        void push(int node, int l, int r) {
            if (!hasLazy[node] || l == r) {
                return;
            }

            int mid = (l + r) / 2;

            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);

            hasLazy[node] = false;
        }

        void update(int node, int l, int r,
                    int ql, int qr, int val) {

            if (ql > r || qr < l) {
                return;
            }

            if (ql <= l && r <= qr) {
                apply(node, l, r, val);
                return;
            }

            push(node, l, r);

            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr, val);
            update(node * 2 + 1, mid + 1, r,
                   ql, qr, val);

            pull(node);
        }

        long querySum(int node, int l, int r,
                      int ql, int qr) {

            if (ql > r || qr < l) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return sum[node];
            }

            push(node, l, r);

            int mid = (l + r) / 2;

            return querySum(node * 2, l, mid, ql, qr)
                 + querySum(node * 2 + 1, mid + 1, r,
                            ql, qr);
        }

        // Find first index in [ql, qr] whose value >= x.
        int findFirst(int node, int l, int r,
                      int ql, int qr, int x) {

            if (r < ql || l > qr || max[node] < x) {
                return -1;
            }

            if (l == r) {
                return l;
            }

            push(node, l, r);

            int mid = (l + r) / 2;

            int res = findFirst(node * 2, l, mid,
                                ql, qr, x);

            if (res != -1) {
                return res;
            }

            return findFirst(node * 2 + 1, mid + 1, r,
                             ql, qr, x);
        }

        void update(int l, int r, int val) {
            if (l <= r) {
                update(1, 0, n - 1, l, r, val);
            }
        }

        long querySum(int l, int r) {
            if (l > r) {
                return 0;
            }

            return querySum(1, 0, n - 1, l, r);
        }

        int findFirst(int l, int r, int x) {
            if (l > r) {
                return -1;
            }

            return findFirst(1, 0, n - 1, l, r, x);
        }
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        SegmentTree seg = new SegmentTree(nums);

        int right = n - 1;

        long cost = 0;
        long ans = 0;

        // Process starting indices from right to left.
        for (int left = n - 1; left >= 0; left--) {

            if (left < right) {

                int x = nums[left];

                // Find first position whose prefix maximum
                // is already >= x.
                int pos = seg.findFirst(
                    left + 1, right, x
                );

                int end = (pos == -1) ? right : pos - 1;

                if (left + 1 <= end) {

                    // Calculate the additional operations.
                    long oldSum = seg.querySum(
                        left + 1, end
                    );

                    long newSum =
                        (long) (end - left) * x;

                    cost += newSum - oldSum;

                    // Update prefix maximum values.
                    seg.update(left + 1, end, x);
                }
            }

            // Shrink the window while cost exceeds k.
            while (cost > k && right > left) {

                long currentMax = seg.querySum(right, right);

                cost -= currentMax - nums[right];

                right--;
            }

            // All subarrays [left...i], left <= i <= right,
            // are valid.
            ans += right - left + 1;
        }

        return ans;
    }
}
