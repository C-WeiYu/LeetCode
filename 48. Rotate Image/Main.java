class Solution {
    public void rotate(int[][] matrix) {
        int l = 0 ;
        int r = matrix.length - 1 ;
        while(l < r){
            int top = l ;
            int bottom = r ;
            for(int i = 0 ; i < r-l ; i++){ 
                int temp = matrix[top][l+i];

                matrix[top][l+i] = matrix[bottom-i][l];

                matrix[bottom-i][l] = matrix[bottom][r-i];

                matrix[bottom][r-i] = matrix[top+i][r];

                matrix[top+i][r] = temp;

            }
            l+=1;
            r-=1;
        }
    }
}
