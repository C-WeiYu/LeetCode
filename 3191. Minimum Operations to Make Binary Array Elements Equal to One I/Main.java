class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int res = 0 ;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] == 0){
                res++;
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
            }
        }
        return (nums[n - 1] + nums[n - 2] == 2) ? res : -1 ;        
    }
}
