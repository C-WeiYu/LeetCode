class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] err = {};
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for(int i = 0 ; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (int i = 0 ; i < nums.length ; i++){
            int r = target - nums[i];
            if(map.containsKey(r) && map.get(r)!= i){
                int[] ans = {i,map.get(r)};
                return ans;
            }
        }
        return err;
    }
}
