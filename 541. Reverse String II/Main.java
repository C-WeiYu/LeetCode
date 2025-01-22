class Solution {
    public String reverseStr(String s, int k) {
        char[] res = s.toCharArray();
        for(int i = 0 ; i < res.length ; i += (2*k)){
            if(i+k > res.length){
                reverse(res, i, res.length-1);
            }
            else{
                reverse(res, i, i+k-1);
            }
        }
        return String.valueOf(res) ;
    }
    private void reverse(char[] charArray, int start, int end){
        while(start < end){
            char temp = charArray[start] ;
            charArray[start] = charArray[end];
            charArray[end] = temp ;
            start += 1 ;
            end -= 1 ;
        }
    }
}
