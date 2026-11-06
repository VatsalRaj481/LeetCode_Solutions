class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        int m = queries.length;
        int[] ans = new int[m];
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> 
            queries[a] - queries[b]
        );
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int idx : indices) {
            int start = queries[idx] - x;
            int end = queries[idx];
            // Add logs within the right boundary
            while (right < logs.length && logs[right][1] <= end) {
                int server = logs[right][0];
                map.put(server, map.getOrDefault(server, 0) + 1);
                right++;
            }
            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {
                int server = logs[left][0];
                map.put(server, map.get(server) - 1);
                if (map.get(server) == 0) {
                    map.remove(server);
                }
                left++;
            }
            ans[idx] = n - map.size();
        }
        return ans;
    }
}