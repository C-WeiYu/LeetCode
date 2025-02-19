class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, char[]> map = new HashMap<>();
        map.put('a', new char[]{'b','c'});
        map.put('b', new char[]{'a','c'});
        map.put('c', new char[]{'a','b'});
        char[] ch = {'a','b','c'};
        int count = (int) Math.pow(2.0, 1d * n-1) ;
        if(k > 3*count){
            return "";
        }
        k--;
        int temp = k / count ;
        char pre = ch[temp];
        sb.append(pre);
        while(sb.length() < n){
            temp = k % count;
            count /= 2;
            if(temp >= count){
                pre = map.get(pre)[1];
            }
            else{
                pre = map.get(pre)[0];
            }
            sb.append(pre);
        }
        return sb.toString();

    }
}
