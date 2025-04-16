class Solution {
    public long countGood(int[] nums, int k) {
        int left = 0;
        int right = -1;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        long temp = 0;
        while(left < n){
            while(temp < k && right + 1 < n){
                right++;
                int num = map.getOrDefault(nums[right], 0);
                temp += num;
                map.put(nums[right], num + 1);
            }
            if(temp < k){
                return res;
            }
            else{
                res += n - right;
                int num = map.get(nums[left]);
                temp -= (num - 1);
                map.put(nums[left], num - 1);
                left++;
            }
        }
        return res;
    }
}
