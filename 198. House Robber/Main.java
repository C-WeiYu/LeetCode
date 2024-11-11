class Solution {
    public int rob(int[] nums) {
        int r1 = 0 ;
        int r2 = 0 ;
        //[r1, r2, n, n+1, ...]        
        for(int num : nums){
            int temp = Math.max(r1+num , r2);
            r1 = r2 ;
            r2 = temp ;
        }
        return r2 ;
    }
}
