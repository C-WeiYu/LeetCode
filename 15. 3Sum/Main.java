class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int l = 0 ; l < nums.length ; l++){
            if(l > 0 && nums[l] == nums[l-1]){
                continue;
            }
            int m = l+1;
            int r = nums.length-1 ;
            while(m<r){
                int sum = nums[l] + nums[m] + nums[r];
                if(sum > 0){
                    r -= 1;
                }
                else if(sum < 0){
                    m += 1 ;
                }
                else{
                    ans.add(Arrays.asList(nums[l], nums[m], nums[r]));
                    m += 1;
                    while(nums[m] == nums[m-1] && m < r){
                        m += 1;
                    }
                }
            }
        }
        return ans ;       
    }
}
