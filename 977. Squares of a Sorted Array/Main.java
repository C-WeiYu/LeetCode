class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0 ;
        int r = nums.length - 1 ;
        int[] res = new int[nums.length];
        int len = res.length - 1 ;
        for(int i = len ; i >= 0 ; i--){
            if(Math.abs(nums[l]) > Math.abs(nums[r])){
                res[i] = nums[l] * nums[l];
                l++ ;
            }
            else{
                res[i] = nums[r] * nums[r];
                r-- ;
            }
        }
        return res; 
    }
}
