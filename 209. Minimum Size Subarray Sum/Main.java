class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0 ;
        int l = 0 ;
        int r = 0 ;
        while(r < nums.length){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(r-l+1, res);
                sum -= nums[l];
                l += 1;
            }
            r += 1;
        }
        if(res == Integer.MAX_VALUE) return 0 ;
        return res ;     
    }
}
