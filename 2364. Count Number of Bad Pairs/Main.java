class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        long res = totalPairs(len-1);
        for(int i = 0; i < nums.length; i++){
            res -= (map.merge(nums[i]-i, 1, (a,b) -> a+b) -1);
        }
        return res ;        
    }
    private long totalPairs(int i){
        long res = (long) (i+1)*i/2 ;
        return res ;
    }
}
