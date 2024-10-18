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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int q = queue.size() ;
            for(int i = 0 ; i < q ; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    temp.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(temp.size() > 0){
                ans.add(temp);
            }
        }
        return ans;
    }
}
