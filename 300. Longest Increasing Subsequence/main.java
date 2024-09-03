class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> LIS = new ArrayList<Integer>();
        LIS.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] > LIS.get(LIS.size()-1)){
                LIS.add(nums[i]);
            }
            else{
                int count = Collections.binarySearch(LIS,nums[i]) ;
                if(count < 0 ){
                    LIS.set(-count-1,nums[i]);
                }
            }
        }
        return LIS.size();
    }
}
