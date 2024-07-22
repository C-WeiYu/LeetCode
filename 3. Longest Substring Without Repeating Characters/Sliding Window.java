class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0 , ans = 0 ;
        int len = s.length();
        HashMap <Character,Integer> sub = new HashMap <Character,Integer>();
        while(r < len ){
            if(sub.containsKey(s.charAt(r))){
                l = Math.max(sub.get(s.charAt(r)) + 1, l );                
            }
            sub.put(s.charAt(r),r) ;
            ans = Math.max(ans , r-l+1) ;
            r += 1 ;
        }
        return ans ;
    }
}
