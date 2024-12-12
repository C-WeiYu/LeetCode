/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val == p.val || root.val == q.val ){
                break ;
            }
            if(root.val < Math.max(p.val, q.val) && root.val > Math.min(p.val, q.val)){
                break ;
            }
            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else if(root.val > p.val && root.val > q.val){
                root = root.left ;
            }        
        }
        return root ;
    }
}
