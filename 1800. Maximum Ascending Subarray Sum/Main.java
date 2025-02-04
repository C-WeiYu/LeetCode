class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                temp += nums[i];
            }
            else{
                res = Math.max(res, temp);
                temp = nums[i];
            }
        }
        return Math.max(res, temp);  
    }
}
