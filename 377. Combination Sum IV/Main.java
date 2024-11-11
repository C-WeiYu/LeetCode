class Solution {
    public int combinationSum4(int[] nums, int target) {
        //dp[i]儲存當target=i時，nums中元素能組成的總次數
        int[] dp = new int[target+1];
        dp[0] = 1 ;
        for(int i = 1 ; i <= target ; i ++){
            for(int num : nums){
                if(num <= i){
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
