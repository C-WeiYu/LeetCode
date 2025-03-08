class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int w = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] == 'W'){
                w++;
            }
            if(i >= k ){
                if(arr[i-k] == 'W'){
                    w--;
                }
            }
            if(i >= k-1){
                res = Math.min(res, w);
            }
        }
        return res ;
    }
}
