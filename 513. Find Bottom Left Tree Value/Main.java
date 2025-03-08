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
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2];
        dfs(root, 1, res); 
        return res[0] ;
    }
    private void dfs(TreeNode root, int depth, int[] res){
        if(root == null){
            return ;
        }
        if(depth > res[1]){
            res[0] = root.val;
            res[1] = depth;
        }

        dfs(root.left, depth+1, res);
        dfs(root.right, depth+1, res);
    }
}
