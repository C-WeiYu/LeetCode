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
    int count;
    int max;
    List<Integer> ans;
    TreeNode prev;
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = ans.get(i);
        }
        return res ;
    }

    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(prev != null && prev.val == root.val){
            count++;
        }
        else{
            count = 1;
        }
        if(count > max){
            ans = new ArrayList<>();
            ans.add(root.val);
            max = count ;
        }
        else if (count == max){
            ans.add(root.val);
        }
        prev = root;
        inOrder(root.right);
    }
}
