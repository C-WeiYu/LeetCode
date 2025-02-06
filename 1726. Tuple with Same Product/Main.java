class Solution {
    public int tupleSameProduct(int[] nums) {
        int res = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int product = nums[i] * nums[j] ;
                    res += map.getOrDefault(product,0)*8;
                    map.merge(product, 1, (a,b) -> a+b);
                }
            }
        return res ;

    }
}
