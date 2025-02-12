class Solution {
    public int maximumSum(int[] nums) {
        int res = -1 ;
        int[] max = new int[82];
        for(int num : nums){
            int digit = 0;
            int temp = num;
            while(temp > 0){
                digit += temp % 10;
                temp /= 10;
            }
            if(max[digit] != 0){
                res = Math.max(res, max[digit] + num);
            }
            max[digit] = Math.max(max[digit], num);
        }
        return res ;        
    }
}
