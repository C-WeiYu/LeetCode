class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < n ; i++){
            for(int k = 0 ; k < m ; k++){
                if(i == 0 || k == 0 ){
                    dp[k][i] = 1 ;
                }
                else{
                    dp[k][i] = dp[k-1][i] + dp[k][i-1];
                }
            }
        }
       return dp[m-1][n-1];
    }
}
