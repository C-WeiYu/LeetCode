class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String num : nums){
            set.add(num);
        }
        return dfs(set,nums.length,"");
    }
    private String dfs(Set nums, int len, String curr){
            if(curr.length() == len){
                if(!nums.contains(curr)){
                    return curr;
                }
                return "";
            }
            String addZero = dfs(nums,len,curr+"0");
            if(addZero.length() > 0){
                return addZero;
            }
            return dfs(nums,len,curr+"1");
    }
}
