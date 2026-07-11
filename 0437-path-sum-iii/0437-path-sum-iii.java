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
    int paths=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        dfs(root,0,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return paths;
    }
    private void dfs(TreeNode node,long sumSoFar,int targetSum){
        if(node==null)return;
        sumSoFar+=node.val;
        if(sumSoFar==targetSum){
            paths++;
        }
        dfs(node.left,sumSoFar,targetSum);
        dfs(node.right,sumSoFar,targetSum);
    }
}