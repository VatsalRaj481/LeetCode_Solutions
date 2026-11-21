class Solution {
    int[] answer;
    int[] last;
    List<Integer>[] children;
    List<Integer>[] newChildren;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        answer = new int[n];
        last = new int[26];
        children = new ArrayList[n];
        newChildren = new ArrayList[n];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
            newChildren[i] = new ArrayList<>();
        }
        // Build original tree
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        // Determine new parents using original tree
        dfsBuild(0, parent, s);
        // Calculate subtree sizes in modified tree
        dfsSize(0);
        return answer;
    }
    void dfsBuild(int node, int[] parent, String s) {
        int ch = s.charAt(node) - 'a';
        int previous = last[ch];
        // Find the new parent
        int newParent = previous == -1 ? parent[node] : previous;
        if (node != 0) {
            newChildren[newParent].add(node);
        }
        // Current node becomes the closest ancestor
        last[ch] = node;
        // Visit original children
        for (int child : children[node]) {
            dfsBuild(child, parent, s);
        }
        // Backtrack
        last[ch] = previous;
    }
    int dfsSize(int node) {
        int size = 1;
        for (int child : newChildren[node]) {
            size += dfsSize(child);
        }
        answer[node] = size;
        return size;
    }
}