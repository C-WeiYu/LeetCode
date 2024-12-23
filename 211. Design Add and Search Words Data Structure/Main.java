class DictionaryNode{
    public char val;
    public Map<Character, DictionaryNode> dict;
    public boolean isEnd = false;
    public DictionaryNode(){
        dict = new HashMap<>();
    }
    public DictionaryNode(char ch){
        dict = new HashMap<>();
        val = ch ;
    }

}
class WordDictionary {
    private DictionaryNode root ;
    public WordDictionary() {
        root = new DictionaryNode();       
    }
    
    public void addWord(String word) {
        DictionaryNode node = root ;
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.dict.containsKey(ch)){
                node.dict.put(ch, new DictionaryNode(ch));
            }
            node = node.dict.get(ch);
        }
        node.isEnd = true ;
    }
    
    public boolean search(String word) {
        return searchHelper(root, word, 0 );
    }

    private boolean searchHelper(DictionaryNode node, String word, int index){
        if(index == word.length()){
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for(DictionaryNode child : node.dict.values()){
                if(searchHelper(child, word, index+1)){
                    return true ;
                }
            }
            return false ;    
        }
        else{
            if(!node.dict.containsKey(ch)){
                return false;
            }
            node = node.dict.get(ch);
            return searchHelper(node, word, index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
