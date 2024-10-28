class Solution {
    public boolean isPalindrome(String s) {
        int pref = 0 ;
        int suff = s.length()-1;
        while(pref < suff){
            if(!(Character.isLetterOrDigit(s.charAt(pref)))){
                pref += 1 ;
                }
            else if(!(Character.isLetterOrDigit(s.charAt(suff)))){
                suff -= 1 ;
            }
            else{
                if(Character.toLowerCase(s.charAt(pref)) != Character.toLowerCase(s.charAt(suff))){
                    return false ;
                }
                pref += 1 ;
                suff -= 1 ;
            }
        }
        return true ;
    }
}
