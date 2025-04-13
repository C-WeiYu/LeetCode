class Solution {
    long mod = (long) Math.pow(10, 9) + 7;
    public int countGoodNumbers(long n) {
        long count = n / 2;
        long res = helper(20, count);
        if(n % 2 == 1){
            res *= 5;
            res %= mod;
        }
        return (int) res;
    }
    private long helper(long x, long y){
        long res = 1;
        long mul = x;
        while(y > 0){
            if(y % 2 == 1){
                res = (res * mul) % mod;
            }
            mul = mul * mul % mod;
            y /= 2;
        }
        return res;
    }
}
