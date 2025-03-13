class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        int sum = 0 ;
        int res = 0;
        for(int i = 0; i <n ; i++){
            while(sum + diff[i] < nums[i]){
                int l = queries[res-1][0];
                int r = queries[res-1][1];
                int val = queries[res-1][2];
                res++;
                if(res > queries.length){
                    return -1 ;
                }
                if(r >= i){
                    diff[Math.max(l, i)] += val ;
                    diff[r + 1] -= val ;
                }
            }
            sum += diff[i];
        }
        return res ;
    }
}
