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
    int i = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans ;
    }
    private void inOrder(TreeNode root, int k){
        if(root == null){
            return ;
        }
        inOrder(root.left, k);
        i++ ;
        if(i == k){
            ans = root.val;
        }
        inOrder(root.right, k);
    }
}
