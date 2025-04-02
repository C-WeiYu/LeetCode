class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        char[] reverse = new char[chars.length];
        int i = chars.length-1 , j , k , r = 0;
        while(i >= 0 && chars[i]== ' '){
            i--;
        }
        while(i >= 0 ){
            j = i ;

            while(i >= 0 && chars[i] != ' '){
                i--;
            }
            if(r > 0){
                reverse[r++] = ' ';
            }

            for(k = i + 1 ; k <= j ; k++){
                reverse[r++] = chars[k];
            }

            while(i >= 0 && chars[i] == ' '){
                i--;
            }
        }
        return new String(reverse, 0 , r);
    }
}
