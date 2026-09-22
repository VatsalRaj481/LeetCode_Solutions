class Solution {
    private int k;
    private int size;
    private int[][] tree;
    private int[] product;
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        size = 1;
        while (size < n) {
            size <<= 1;
        }
        tree = new int[2 * size][k];
        product = new int[2 * size];
        // Build leaf nodes
        for (int i = 0; i < n; i++) {
            int rem = nums[i] % k;
            product[size + i] = rem;
            tree[size + i][rem] = 1;
        }
        // Build internal nodes
        for (int i = size - 1; i >= 1; i--) {
            merge(i, i << 1, (i << 1) | 1);
        }
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];
            // Persistent point update
            update(index, value % k);
            // Query the range [start, n - 1]
            result[q] = query(start, n, x);
        }
        return result;
    }

    // Merge two children into their parent
    private void merge(int parent, int left, int right) {
        int leftProduct = product[left];
        int rightProduct = product[right];

        product[parent] = (leftProduct * rightProduct) % k;

        for (int r = 0; r < k; r++) {
            tree[parent][r] = tree[left][r];
        }

        // Prefixes that extend into the right child
        for (int r = 0; r < k; r++) {
            int newRem = (leftProduct * r) % k;

            tree[parent][newRem] += tree[right][r];
        }
    }

    // Update nums[index]
    private void update(int index, int value) {
        int pos = size + index;

        // Reset leaf
        for (int r = 0; r < k; r++) {
            tree[pos][r] = 0;
        }

        tree[pos][value] = 1;
        product[pos] = value;

        // Recalculate ancestors
        pos >>= 1;

        while (pos >= 1) {
            merge(pos, pos << 1, (pos << 1) | 1);
            pos >>= 1;
        }
    }

    // Query range [left, right)
    private int query(int left, int right, int x) {

        int l = left + size;
        int r = right + size;

        // Store segment-tree nodes in order
        int[] leftNodes = new int[32];
        int[] rightNodes = new int[32];

        int leftCount = 0;
        int rightCount = 0;

        while (l < r) {
            if ((l & 1) == 1) {
                leftNodes[leftCount++] = l++;
            }

            if ((r & 1) == 1) {
                rightNodes[rightCount++] = --r;
            }

            l >>= 1;
            r >>= 1;
        }

        // Empty prefix: product identity is 1 % k
        int accProduct = 1 % k;
        int[] acc = new int[k];
        int[] temp = new int[k];

        // Merge left-side nodes in order
        for (int i = 0; i < leftCount; i++) {
            int node = leftNodes[i];

            mergeInto(acc, accProduct, node, temp);

            accProduct = (accProduct * product[node]) % k;

            int[] swap = acc;
            acc = temp;
            temp = swap;
        }

        // Merge right-side nodes in reverse order
        for (int i = rightCount - 1; i >= 0; i--) {
            int node = rightNodes[i];

            mergeInto(acc, accProduct, node, temp);

            accProduct = (accProduct * product[node]) % k;

            int[] swap = acc;
            acc = temp;
            temp = swap;
        }

        return acc[x];
    }

    // Merge accumulator A with segment-tree node B into dest
    private void mergeInto(
            int[] A,
            int productA,
            int nodeB,
            int[] dest) {

        // Existing prefixes from A
        System.arraycopy(A, 0, dest, 0, k);

        // Prefixes extending into B
        for (int r = 0; r < k; r++) {
            int newRem = (productA * r) % k;

            dest[newRem] += tree[nodeB][r];
        }
    }
}