class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] res = new int[26];
        for(int i = 0 ; i < words[0].length() ; i++){
            res[words[0].charAt(i)-'a'] += 1 ;
        }
        for(String word:words){
            res = intersection(res, count(word));
        }
        for(int i = 0 ; i < 26 ; i++){
            if(res[i] != 0){
                char ch = (char) ('a' + i);
                String str = String.valueOf(ch);
                while(res[i] > 0){
                    ans.add(str);
                    res[i] -= 1;
                }
            }
        }
        return ans ;
    }
    
    private int[] intersection(int[] word1, int[] word2){
        int[] tempArr = new int[26];
        for(int i = 0 ; i < 26 ; i++){
            tempArr[i] = Math.min(word1[i], word2[i]);
        }
        return tempArr;
    }

    private int[] count(String word){
        int[] wordArr = new int[26];
        for(int i = 0 ; i < word.length() ; i++){
            wordArr[word.charAt(i)-'a'] += 1 ;
        }
        return wordArr ;
    }
}
