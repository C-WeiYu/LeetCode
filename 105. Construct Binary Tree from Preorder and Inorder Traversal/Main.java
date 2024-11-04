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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode createTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        //root為preorder中的第一個節點
        TreeNode root = new TreeNode(preorder[pStart]);

        int index = 0; //Index代表root節點在Inorder中的index(透過while迴圈找)
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        //將Tree拆分為left跟right的subtree
        root.left = createTree(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        root.right = createTree(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return root;
    }
}
