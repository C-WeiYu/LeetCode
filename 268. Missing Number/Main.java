class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0 ;
        int i = 0 ;
        while(i < nums.length){
            ans = ans ^ i ^ nums[i];
            i += 1;
        }
        return ans ^ i ;
    }
}
