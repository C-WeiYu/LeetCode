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
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root);
        return res;
    }
    private void traversal(TreeNode root){
        if(root == null){
            return ;
        }

        int len = sb.length();
        if(len > 0 ){
            sb.append("->");
        }

        sb.append(root.val);
        traversal(root.left);
        traversal(root.right);

        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        sb.setLength(len);
    }

}
