import java.util.StringJoiner;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringJoiner sj  = new StringJoiner(",") ;
        
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
            if(r == null){
                sj.add("#");
            }
            else{
                sj.add(Integer.toString(r.val));
                queue.offer(r.left);
                queue.offer(r.right);
            }
        }
        System.out.println(sj.toString());
        return sj.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null ;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.offer(root);
        int i = 1 ;
        while(i < values.length){
            TreeNode parent = queue.poll();
            if(!values[i].equals("#")){
                TreeNode node = new TreeNode(Integer.valueOf(values[i]));
                parent.left = node ;
                queue.offer(node);
            }
            i+=1;
            if(!values[i].equals("#")){
                TreeNode node = new TreeNode(Integer.valueOf(values[i]));
                parent.right = node ;
                queue.offer(node);
            }
            i+=1;
        }
        return root ;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
