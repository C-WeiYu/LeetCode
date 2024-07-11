class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] err ={};
        for(int i = 0 ; i < nums.length ; i++){
            for(int k = i+1 ; k < nums.length ; k++){
                if(nums[i]+nums[k]==target){
                    int[] ans = {i,k};
                    return ans;
                }
            }
        }
        return err;
    }
}
