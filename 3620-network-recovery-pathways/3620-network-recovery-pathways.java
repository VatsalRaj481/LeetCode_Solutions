class Solution {
    static class Edge {
        int to, cost;
        Edge next;
        Edge(int to, int cost, Edge next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
        }
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        Edge[] graph = new Edge[n];
        int[] indegree = new int[n];
        int max = 0;

        for (int[] e : edges) {
            graph[e[0]] = new Edge(e[1], e[2], graph[e[0]]);
            indegree[e[1]]++;
            max = Math.max(max, e[2]);
        }

        int[] q = new int[n];
        int[] topo = new int[n];
        int h = 0, t = 0, idx = 0;

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q[t++] = i;

        while (h < t) {
            int u = q[h++];
            topo[idx++] = u;
            for (Edge e = graph[u]; e != null; e = e.next) {
                if (--indegree[e.to] == 0)
                    q[t++] = e.to;
            }
        }

        int lo = 0, hi = max, ans = -1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(graph, topo, online, k, mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(Edge[] graph, int[] topo, boolean[] online, long k, int limit) {
        int n = online.length;
        long inf = Long.MAX_VALUE / 4;
        long[] dist = new long[n];

        for (int i = 0; i < n; i++)
            dist[i] = inf;

        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == inf)
                continue;
            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (Edge e = graph[u]; e != null; e = e.next) {
                if (e.cost < limit)
                    continue;
                if (e.to != n - 1 && !online[e.to])
                    continue;
                if (dist[e.to] > dist[u] + e.cost)
                    dist[e.to] = dist[u] + e.cost;
            }
        }

        return dist[n - 1] <= k;
    }
}