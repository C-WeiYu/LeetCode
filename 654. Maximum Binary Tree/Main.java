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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null ;
        }
        int rootVal = Integer.MIN_VALUE;
        int rootIndex = -1;
        for(int i = start; i <= end; i++){
            if(rootVal < nums[i]){
                rootVal = nums[i];
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(nums, start, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);

        return root;
    }
}
