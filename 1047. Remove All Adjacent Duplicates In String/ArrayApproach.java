class Solution {
    public String removeDuplicates(String s) {
        char[] charArr = s.toCharArray();
        int top = -1;
        for (char ch: charArr) {
            if (top >= 0 && charArr[top] == ch){
                top-- ;
            }
            else{
                top++ ;
                charArr[top] = ch;
            }
        }
        return new String(charArr, 0, top+1);
    }
}
