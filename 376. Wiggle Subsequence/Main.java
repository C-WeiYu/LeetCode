class Solution {
    public int wiggleMaxLength(int[] nums) {
        int valley = 1;
        int peak = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                peak = valley + 1;
            }
            else if(nums[i] < nums[i - 1]){
                valley = peak + 1;
            }
        }
        return Math.max(peak, valley);
    }
}
