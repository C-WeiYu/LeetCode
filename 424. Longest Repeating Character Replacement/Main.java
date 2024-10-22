class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int max = 0 ;
        int ans = 0 ;
        int l = 0 ;
        for(int r = 0 ; r < s.length() ; r++ ){
            arr[s.charAt(r) - 'A'] += 1 ;

            max = Math.max(max , arr[s.charAt(r)-'A']);

            if(r-l+1 - max > k){
                arr[s.charAt(l)-'A'] -= 1 ;
                l += 1 ;
            }
            ans = Math.max(ans, r-l+1);

        }
        return ans ;
    }
}
