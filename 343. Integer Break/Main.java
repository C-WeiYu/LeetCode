class Solution {
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int max = i;
            int l = 1;
            int r = i - 1;
            while(l <= r){
                max = Math.max(max, dp[l] * dp[r]);
                l++;
                r--;
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
