class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0 ;
        int temp = 1 ;
        Set<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }
        for(int num:hs){
            if(!(hs.contains(num-1))){
                int tempNum = num ;
                temp = 1 ;
                while(hs.contains(tempNum+1)){
                    temp += 1 ;
                    tempNum += 1 ;
                }
            }
            res = Math.max(res, temp);
        }
        return res ;
    }
}
