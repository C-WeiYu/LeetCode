class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        long iMax = 0;
        long dMax = 0;
        for(int num : nums){
            res = Math.max(res, dMax * num);
            dMax = Math.max(dMax, iMax - num);
            iMax = Math.max(iMax, num);
        }
        return res;
    }
}
