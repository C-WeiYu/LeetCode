class Solution {
    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
    
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        
        while(left < right){
            int mid = (left + right) / 2;
            if(canStealKHouses(nums, mid, k)){
                right = mid;
            }
            else{
                left = mid + 1 ;
            }
        }
        return left ;
    }

    private boolean canStealKHouses(int[] nums, int capability, int k){
        int count = 0 ;
        int i = 0;
        while(i < nums.length){
            if(nums[i] <= capability){
                count++;
                i += 1;
            }
            i++;
        }
        return count >= k ;
    }
}
