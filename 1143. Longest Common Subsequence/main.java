class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1+1][len2+1]; //讓矩陣格多一格，配合下面for迴圈中的index，從1開始，讓i-1和j-1不會有小於0的狀況產生
        text1 = "#"+text1;                    //加#是為了讓下面for迴圈中的index和String的index可以對上
        text2 = "#"+text2;
        for(int i = 1 ; i < len1+1 ; i++){
            for(int j = 1 ; j < len2+1 ; j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
