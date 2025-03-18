class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int res = 1;
        int curr = nums[l];
        for(int i = 1; i < nums.length; i++){
            while((curr & nums[i]) != 0){
                curr ^= nums[l];
                l++;
            }
            res = Math.max(i - l + 1, res);
            curr |= nums[i];
        }
        return res ;
    }
}
