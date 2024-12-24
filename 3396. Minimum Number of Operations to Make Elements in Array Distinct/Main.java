class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int start = nums.length - 1  ;
        int count = 0;
        while(start >= 0){
            set.add(nums[start]);
            count += 1;
            if(count != set.size()){
                break;
            }
            start -= 1;
        }
        if(set.size() == count) return 0 ;
        if((start+1) % 3 == 0) return (start+1)/3 ;
        return start/3 + 1 ;
    }
}
