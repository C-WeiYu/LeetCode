class Solution {
    public int minOperations(int[] nums, int k) {
        int[] freq = new int[101];
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            freq[num]++;
            if(num < min){
                min = num;
            }
        }
        if(min < k) {
            return -1;
        }
        for(int i = freq.length - 1; i > k; i--){
            if(freq[i] > 0){
                res++;
            }
        }
        return res;
    }
}
