// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     long maxNodes=0;
//     public int longestZigZag(TreeNode root) {
//         if(root==null)return 0;
//         dfs(root,'l',1);
//         dfs(root,'r',1);
//         longestZigZag(root.left);
//         longestZigZag(root.right);
//         return maxNodes-1;
//     }
//     private void dfs(TreeNode node,char dir,long nodes){
//         if(node==null)return;
//         maxNodes=Math.max(nodes,maxNodes);
//         if(dir=='l'){
//             dfs(node.left,'r',nodes+1);
//         }
//         else{
//             dfs(node.right,'l',nodes+1);
//         }
//     }
// }

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
    int maxNodes=0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxNodes;
    }   
    private int[] dfs(TreeNode node){
        if(node==null)return new int[]{-1,-1};
        int leftChild[] = dfs(node.left);
        int rightChild[] = dfs(node.right);

        int left = 1+leftChild[1];
        int right=1+rightChild[0];

        maxNodes=Math.max(maxNodes,Math.max(left,right));
        return new int[]{left,right};
    }
}