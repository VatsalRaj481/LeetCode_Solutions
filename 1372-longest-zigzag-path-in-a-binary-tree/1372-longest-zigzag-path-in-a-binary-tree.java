class Solution {
    int longest = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 'l');
        return longest;
    }

    private void dfs(TreeNode root, int count, char dir) {
        if (root == null) return;
        longest = Math.max(longest, count);

        if (dir == 'r') {
            dfs(root.left, count + 1, 'l');
            dfs(root.right, 1, 'r');
        } else {
            dfs(root.left, 1, 'l');
            dfs(root.right, count + 1, 'r');
        }
    }
}