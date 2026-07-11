class Solution {
    char LEFT = 'l';
    char RIGHT = 'r';

    int longest = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, LEFT);
        return longest;
    }

    private void dfs(TreeNode root, int count, char prevMove) {
        if (root == null) return;

        longest = Math.max(longest, count);

        if (prevMove == RIGHT) {
            dfs(root.left, count + 1, LEFT);
            dfs(root.right, 1, RIGHT);
        } else {
            dfs(root.left, 1, LEFT);
            dfs(root.right, count + 1, RIGHT);
        }
    }
}