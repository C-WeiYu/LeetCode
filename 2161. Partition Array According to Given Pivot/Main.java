class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int l = 0 ;
        int r = nums.length-1 ;
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < pivot){
                res[l++] = nums[i];
            }
        }
        for(int i = nums.length-1 ; i >= 0 ; i--){
            if(nums[i] > pivot){
                res[r--] = nums[i];
            }
        }
        while(l <= r){
            res[l++] = pivot ;
        }
        return res ;
    }
}
