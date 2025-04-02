class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] total = new int[26];
        for(char ch : magazine.toCharArray()){
            total[ch-'a'] += 1;
        }
        for(char ch : ransomNote.toCharArray()){
            total[ch - 'a'] -= 1;
            if(total[ch - 'a'] < 0 ){
                return false;
            }
        }
        return true;
    }
}
