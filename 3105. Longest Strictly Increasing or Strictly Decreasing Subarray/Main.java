class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int inc = 1;
        int dec = 1;
        if(nums.length == 1) return 1 ;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                inc++;
                dec = 1;
            }
            else if(nums[i] < nums[i-1]){
                dec++;
                inc = 1;
            }
            else{
                inc = 1;
                dec = 1;
            }
            maxLen = Math.max(maxLen, Math.max(dec, inc));
        }
        return maxLen;
    }
}
