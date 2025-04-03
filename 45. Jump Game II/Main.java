class Solution {
    public int jump(int[] nums) {
        int curr = 0;
        int reachable = 0;
        int res = 0 ;
        for(int i = 0; i < nums.length - 1; i ++){
            reachable = Math.max(reachable, i + nums[i]);
            if(i == curr){
                res++;
                curr = reachable;
            }            
        }
        return res;
    }
}
