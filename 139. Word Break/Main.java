class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true ;
        for(int i = s.length() ; i > -1 ; i--){
            for(String word:wordDict){
                if(i + word.length() <= s.length() && s.substring(i,i+word.length()).equals(word))          {
                    dp[i] = dp[i + word.length()];
                }
                if(dp[i] == true){
                    break;
                }
            }
        }
        return dp[0];
    }
}
