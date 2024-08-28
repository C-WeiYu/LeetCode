class Solution {
    public int maxProduct(int[] nums) {
        int pref = 1 ;
        int suff = 1 ; 
        int max = nums[0] ;
        for(int i = 0 ; i < nums.length ; i++){
            pref = pref * nums[i];
            suff = suff * nums[nums.length-i-1];
            max = Math.max(max , Math.max( pref , suff));
            if(pref == 0)
            pref = 1;
            if(suff == 0)
            suff = 1;
    }
    return max;
    }
}
