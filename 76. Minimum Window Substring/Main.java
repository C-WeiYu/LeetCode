class Solution {
    public String minWindow(String s, String t) {
    if(t.length() > s.length()) return "";
    int[] map = new int[128] ;
    int count = t.length();
    int l = 0, r = 0, res = Integer.MAX_VALUE, startIdx = 0;
    for(char c : t.toCharArray()){
        map[c] += 1 ;
    }
    
    char[] chS = s.toCharArray();
    while(r < chS.length){
        if(map[chS[r]] > 0){ // map[char] > 0 ，代表這個char是target之一
            count -= 1;  // 把target-1
        }
        map[chS[r]] -= 1; //  每跑過一個char都-1，left移動的時候才知道哪些是原本要的，如果只有對target的map[char]-1，會導致跟原本就為0的混再一起 (Line 24)
        r += 1 ; //  right window往右繼續找

        while(count == 0){   //  count == 0 表示target char都找完
            if(r-l  < res){   //  原本長度應該為 r-l+1，但因為while前r有多跑一次，所以會變(r-1)-l+1 = r-l
                startIdx = l ; 
                res = r - l ; 
                }
            if(map[chS[l]] == 0){ //  ex：若target中原本需要兩個'a'，假設window中包含3個，那麼這時候map[chS[l]]應該會等於1，表示這個是多的，不需要包含在window中，
                count += 1;       //  ex: input: s = [a,b,b,d] , t=[b,d]，過程中chS ([a,b,c,d]數量)原會是[0,2,0,1]，接著變[0,1,0,1]，只有讀到[0,0,0,1]才代表後面那個b是我們需要的，所以如果left從b移到d，則target count要+1
            }
            map[chS[l]] += 1 ; 
            l += 1 ;

        }
    }
        return res == Integer.MAX_VALUE ? "" : new String(chS,startIdx, res);
    }
}
