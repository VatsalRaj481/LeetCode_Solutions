class Solution {
    List<Integer>[] tree;
    int[] tin, tout, depth, bit;
    int[][] up;
    char[] chars;
    int timer, LOG;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }

        chars = s.toCharArray();
        tin = new int[n];
        tout = new int[n];
        depth = new int[n];

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];
        bit = new int[2 * n + 2];
        timer = 0;

        dfs(0, 0);

        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            updateBIT(tin[i], mask);
            updateBIT(tout[i], mask);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            int u = Integer.parseInt(parts[1]);

            if (parts[0].equals("update")) {
                char c = parts[2].charAt(0);

                if (chars[u] != c) {
                    int mask = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                    updateBIT(tin[u], mask);
                    updateBIT(tout[u], mask);
                    chars[u] = c;
                }
            } else {
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);

                int mask = prefix(tin[u]) ^ prefix(tin[v])
                         ^ (1 << (chars[lca] - 'a'));

                answer.add(Integer.bitCount(mask) <= 1);
            }
        }

        return answer;
    }

    private void dfs(int u, int p) {
        tin[u] = ++timer;
        up[0][u] = p;

        for (int k = 1; k < LOG; k++) {
            up[k][u] = up[k - 1][up[k - 1][u]];
        }

        for (int v : tree[u]) {
            if (v == p) {
                continue;
            }

            depth[v] = depth[u] + 1;
            dfs(v, u);
        }

        tout[u] = ++timer;
    }

    private void updateBIT(int i, int mask) {
        while (i < bit.length) {
            bit[i] ^= mask;
            i += i & -i;
        }
    }

    private int prefix(int i) {
        int mask = 0;

        while (i > 0) {
            mask ^= bit[i];
            i -= i & -i;
        }

        return mask;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}