class Solution {
    int k = 1;
    public String countAndSay(int n) {
        String res = Integer.toString(1);
        while(k < n){
            k++;
            res = getRLE(res);
        }
        return res;
    }
    private String getRLE(String str){
        char[] strArray = str.toCharArray();
        StringBuilder newStr = new StringBuilder();
        int cnt = 1;
        for(int i = 0; i < strArray.length; i++){
            if(i + 1 < strArray.length && strArray[i] == strArray[i + 1]){
                cnt += 1;
            }
            else{
                newStr.append(cnt);
                newStr.append(strArray[i]);
                cnt = 1;
            }
        }
        return newStr.toString();
    }

}
