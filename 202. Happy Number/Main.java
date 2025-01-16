class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0 ;
        while(sum != 1){
            sum = 0 ;
            while(n > 0){
                int digit = n % 10;
                sum +=  digit * digit ;
                n /= 10 ;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n = sum ;
        }
        return true ;
    }
}
