class Solution {
    public int countSubstrings(String s) {
        int res = 0 ;
        int maxRight = 0 ;
        int pos = 0 ;
        s = s.replaceAll("","#") ;
        System.out.println(s);
        int[] rl = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            if(i < maxRight){
                rl[i] = Math.min(rl[2 * pos -i] , maxRight-i) ;
            }
            while(i-rl[i] >= 0 && i+rl[i] < s.length() && s.charAt(i+rl[i]) == s.charAt(i-rl[i])){
                rl[i] += 1 ;
            }
          // rl[i]有包含自己，所以以下在計算index的時候要-1
          // 例如 "#a#"，rl[] = {1,2,1}，當我pos在index=1時，maxRight應該要=2，但rl[1]=2，所以是1+(rl[i]-1)
            if(i+rl[i]-1 > maxRight){ 
                pos = i ;
                maxRight = i + rl[i]-1;
            }
        }
        for(int i = 0 ; i < s.length(); i++){
            res += rl[i]/2 ;
        }
        return res ;

    }
}
