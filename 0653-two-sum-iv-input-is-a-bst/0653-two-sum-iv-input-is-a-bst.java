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
    Set<Integer> set = new HashSet<>();
    boolean flag=false;
    public boolean findTarget(TreeNode root, int k) {
        dfs(root,k);
        return flag;
    }
    private void dfs(TreeNode node,int k){
        if(node==null){
            return;
        }
        if(set.contains(k-node.val)){
            flag=true;
        }
        set.add(node.val);
        dfs(node.left,k);
        dfs(node.right,k);
    }
}