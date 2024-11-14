class Solution {
    public int rob(int[] nums) {
    if(nums.length == 1) return nums[0];
    return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)),helper(Arrays.copyOfRange(nums,1,nums.length))) ;
    }

    private int helper(int[] nums){
        int rob1 = 0 ;
        int rob2 = 0 ;
        for(int num:nums){
            int temp = Math.max(rob1+num, rob2);
            rob1 = rob2 ;
            rob2 = temp ;
        }
        return rob2 ;
    }
}
