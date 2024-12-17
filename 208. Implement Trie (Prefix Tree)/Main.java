class TrieNode{
    public char val ;
    public Map<Character, TrieNode> dict = new HashMap<>();
    public boolean isEnd = false ;
    public TrieNode(){
    }
    public TrieNode(char ch){
        TrieNode node = new TrieNode();
        node.val = ch ;
        node.dict = new HashMap<>();
    }
}

class Trie {
    private TrieNode root ;
    public Trie() {
       root = new TrieNode();
       root.dict = new HashMap<Character, TrieNode>();
    }
    
    public void insert(String word) {
        TrieNode node = root ;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.dict.containsKey(word.charAt(i))){
                node.dict.put(word.charAt(i),new TrieNode(word.charAt(i)));
            }
            node = node.dict.get(word.charAt(i));
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root ;
        for(int i = 0 ; i < word.length(); i++){
            if(!node.dict.containsKey(word.charAt(i))){
                return false;
            }
            node = node.dict.get(word.charAt(i));
        }
        return node.isEnd ;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root ;
        for(int i = 0 ; i < prefix.length(); i++){
            if(!node.dict.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.dict.get(prefix.charAt(i));
        }
        return true ;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
