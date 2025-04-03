class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int curr = 0;
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        while(k > 0){
            int min = nums[curr];
            if(min == 0){
                return res;
            }
            else{
                res += 2 * min * -1;
                nums[curr] *= -1 ;
            }
            if(curr + 1 < nums.length && nums[curr] > nums[curr + 1]){
                curr++;
            }
            k--;
        }
        return res;
    }
}
