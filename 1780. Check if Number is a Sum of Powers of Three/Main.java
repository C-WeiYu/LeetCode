class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n % 3 == 0 || (n-1) % 3 == 0){
            if((n-1) % 3 == 0){
                n-- ;
            }
            if(n >= 3){
                n /= 3 ;
            }
            else if(n == 1 || n == 0){
                return true ;
            }
            else{
                break ;
            }
        }
        return false ;
    }
}
