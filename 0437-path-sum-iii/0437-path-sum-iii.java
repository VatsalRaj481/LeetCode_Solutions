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
//     int paths=0;
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root==null)return 0;
//         dfs(root,0,targetSum);
//         pathSum(root.left,targetSum);
//         pathSum(root.right,targetSum);
//         return paths;
//     }
//     private void dfs(TreeNode node,long sumSoFar,int targetSum){
//         if(node==null)return;
//         sumSoFar+=node.val;
//         if(sumSoFar==targetSum){
//             paths++;
//         }
//         dfs(node.left,sumSoFar,targetSum);
//         dfs(node.right,sumSoFar,targetSum);
//     }
// }

class Solution {
    int paths = 0;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();

        map.put(0L, 1);

        dfs(root, 0L, targetSum, map);

        return paths;
    }

    private void dfs(TreeNode node, long currentSum, int targetSum,
                     HashMap<Long, Integer> map) {

        if(node == null) return;

        currentSum += node.val;

        paths += map.getOrDefault(currentSum - targetSum, 0);

        map.put(currentSum,
                map.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, currentSum, targetSum, map);
        dfs(node.right, currentSum, targetSum, map);

        map.put(currentSum, map.get(currentSum) - 1);
    }
}