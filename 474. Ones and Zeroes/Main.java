class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        int[][] strFreq = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
            int zero = 0;
            int one = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    zero++;
                }
                else{
                    one++;
                }
            }
            strFreq[i][0] = zero;
            strFreq[i][1] = one;
        }        
        for(int[] freq : strFreq){
            int zero = freq[0];
            int one = freq[1];
            for(int i = m; i >= zero; i--){
                for(int j = n; j >= one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j] > res){
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
