class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int total = 0;
            for(int l = 0; l < i; l++){
                total += dp[l] * dp[i - l - 1];
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
