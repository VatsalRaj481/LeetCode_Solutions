/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
    private void dfs(TreeNode node){
        if(node==null)return;
        dfs(node.left);
        if(prev!=null && prev.val>node.val){
            if(first==null){
                first=prev;
            }
            second=node;
        }
        prev=node;
        dfs(node.right);
    }
}