class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] temp = new int[nums.length];
        int suffix = nums[nums.length-1] ;
        temp[0] = nums[0] ; 
        for(int i = 1 ; i < nums.length ; i++){
            temp[i] = temp[i-1] * nums[i] ;
        }
        temp[nums.length-1] = temp[nums.length-2];
        for(int i = nums.length-2 ; i > 0 ; i--){
            temp[i] = temp[i-1] * suffix;
            suffix = suffix * nums[i];
        }
        temp[0] = suffix;
        return temp;
    }
}
