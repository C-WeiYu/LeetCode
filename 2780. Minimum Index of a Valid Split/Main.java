class Solution {
    public int minimumIndex(List<Integer> nums) {
        int len = nums.size();
        int candidate = nums.get(0);
        int count = 0;
        int totalCount = 0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                candidate = num;
                count = 1;
            }
        }
        for(int num : nums){
            if(num == candidate){
                totalCount++;
            }
        }
        count = 0 ;
        for(int i = 0; i < len; i++){
            if(nums.get(i) == candidate){
                count++;
            }
            if(count * 2 > i + 1 && (totalCount-count) * 2 > len - i -1){
                return i;
            }
        }
        return -1 ;
    }
}
