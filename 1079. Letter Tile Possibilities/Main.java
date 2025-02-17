class Solution {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for(char ch : tiles.toCharArray()){
            count[ch-'A']++;
        }        
        return TilesCounter(count);
    }
    private int TilesCounter(int[] count){
        int res = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                res++;
                count[i]--;
                res += TilesCounter(count);
                count[i]++;
            }
        }
        return res ;
    }
}
