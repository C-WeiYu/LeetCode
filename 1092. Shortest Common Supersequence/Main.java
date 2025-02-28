class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1 ; i <= len1 ; i++){
            for(int j = 1 ; j <= len2 ; j++){
                if(strArr1[i-1] == strArr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        while(len1 > 0 || len2 > 0){
            if(len1 == 0){
                len2--;
                c = strArr2[len2];
            }
            else if(len2 == 0){
                len1--;
                c = strArr1[len1];
            }
            else if(strArr1[len1-1] == strArr2[len2-1]){
                len1--;
                len2--;
                c = strArr1[len1];
            }
            else if(dp[len1-1][len2] == dp[len1][len2]){
                len1-- ;
                c = strArr1[len1];
            }
            else if(dp[len1][len2-1] == dp[len1][len2]){
                len2-- ;
                c = strArr2[len2];
            }
            sb.insert(0,c);
        }
        return sb.toString();
    }
}
