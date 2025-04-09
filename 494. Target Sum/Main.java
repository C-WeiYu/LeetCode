class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int newTarget = sum - target ;
        if(newTarget < 0 || newTarget % 2 != 0){
            return 0;
        }
        else{
            newTarget /= 2;
        }
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int tar = newTarget; tar >= num; tar--){
                if(dp[tar - num] > 0){
                    dp[tar] += dp[tar - num];
                }
            }
        }
        return dp[newTarget];
    }
}
