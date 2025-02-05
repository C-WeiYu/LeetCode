class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int l = -1 ;
        int r = -1 ;
        for(int i = 0 ; i < s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++ ;
                if(l == -1){
                    l = i;
                }
                else{
                    r = i;
                }
            }
        }
        if(count == 0 ) return true ;
        if(count == 2 && s1.charAt(l) == s2.charAt(r) && s1.charAt(r) == s2.charAt(l)){
            return true ;
        }
        return false ;
    }
}
