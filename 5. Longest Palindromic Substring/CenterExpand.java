class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return "";
        int start = 0 ;
        int end = 0 ;
        int max = 1 ;
        for(int i = 0; i < s.length(); i++){
            int odd = expandPalindrome(s, i, i) ;
            int even = expandPalindrome(s, i, i+1) ;
            int maxLen = Math.max(odd,even);
            if(maxLen > max){
                max = maxLen ;
                start = i - (maxLen-1)/2 ;
                end = i + maxLen/2 ;
            }
        }
        return s.substring(start, end+1);
    }
    private int expandPalindrome(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            l -= 1;
            r += 1;
        }
        return (r-1)-(l+1)+1;
    }
}
