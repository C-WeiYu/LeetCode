class Solution {
    public int climbStairs(int n ) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1 ;
        dp[1] = 1 ;
        return recursion(n,dp);
    }
    private int recursion(int n , int[] dp){
        if(n <= 1 && n >= 0){
            return 1;
        }
        if(dp[n] > 0 ){
            return dp[n];
        }
        dp[n] = recursion(n-1,dp) + recursion(n-2,dp) ;
        return dp[n];
    }
}
