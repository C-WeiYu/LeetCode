class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1 ;
        int[][] res = new int[n][n];
        int left = 0 ; 
        int right = n ;
        int top = 0 ;
        int bottom = n ;
        while(left < right || top < bottom){
            for(int i = left ; i < right ; i++){
                res[top][i] = count ;
                count += 1 ; 
            }
            top += 1 ;

            for(int j = top ; j < bottom ; j++){
                res[j][right-1] = count ;
                count += 1 ;
            }
            right -= 1 ;

            for(int i = right-1 ; i >= left ; i--){
                res[bottom-1][i] = count ;
                count += 1 ;
            }
            bottom -= 1 ;

            for(int j = bottom-1 ; j >= top; j--){
                res[j][left] = count ;
                count += 1;
            }
            left += 1 ;
       }

       return res ;
                
    }
}
