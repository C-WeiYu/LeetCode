class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 1) return "";
        int maxLen = 0;
        String maxStr = s.substring(0,1);
        s = "#"+s.replaceAll("","#")+"#";
        int rl[] = new int[s.length()];
        int pos = 0 ;
        int maxRight = 0 ;
        for(int i = 0 ; i < s.length(); i++){
            if(i < maxRight){
                rl[i] = Math.min(rl[2 * pos - i], maxRight-i);
            }
            while(i-rl[i]>=0 && i+rl[i]<s.length() && s.charAt(i-rl[i])==s.charAt(i+rl[i])){
                rl[i] += 1 ;
            }
            if(i+(rl[i]-1) > maxRight){
                maxRight = i+(rl[i]-1);
                pos = i ;
            }
            if(rl[i] > maxLen){
                maxLen = rl[i];
                maxStr = s.substring(i-(rl[i]-1), i+(rl[i]-1)+1).replaceAll("#","");
            }
        }
        return maxStr;
    }
}
