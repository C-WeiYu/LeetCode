class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.sort(nums);
        int max = 0;
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 ){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }
        for(int i = 0; i < nums.length; i++){
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        res.add(nums[index]);
        for(int i = index - 1; i >= 0; i--){
            if(nums[index] % nums[i] == 0 && dp[index] == dp[i]+1){
                res.add(0, nums[i]);
                index = i;
            }
        }
        return res;      
    }
}
