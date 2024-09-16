/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)  return null;
        Map<Node, Node> hm = new HashMap<>();
        return dfs(hm,node);
    }
    private Node dfs(Map<Node,Node> hm , Node node){
        if(hm.containsKey(node)){
            return hm.get(node);
        }
        Node copyNode = new Node(node.val);
        hm.put(node,copyNode);
        for(Node nei : node.neighbors){
            copyNode.neighbors.add(dfs(hm,nei));
        }
        return copyNode;
    }
}
