class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length-1);
    }
    private int searchHelper(int[] nums, int target, int l, int r){
        int mid = l + (r-l)/2 ;
        if(l > r){
            return -1 ;
        }
        if(target == nums[mid]) return mid;
        if(target > nums[mid]){
            return searchHelper(nums, target, mid+1, r);
        }
        else{
            return searchHelper(nums, target, l , mid-1);
        }
    }

}
