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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        int leftHeight = 0 ;
        int rightHeight = 0 ;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left != null){
            leftHeight += 1;
            left = left.left;
        }        
        while(right != null){
            rightHeight += 1;
            right = right.right;
        }        
        if(leftHeight == rightHeight){
            return (int)Math.pow(2.0, 1d * leftHeight+1) - 1 ;
        }

        return countNodes(root.left) + countNodes(root.right) + 1 ;

    }

}
