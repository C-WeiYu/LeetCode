class Solution {
    public void setZeroes(int[][] matrix) {
        Boolean box1 = false ; 
        for(int i = 0 ; i < matrix.length ; i++){
            for(int k = 0 ; k < matrix[0].length ; k++){
                if(matrix[i][k]==0){
                    matrix[0][k] = 0 ;
                    if(i == 0){
                        box1 = true;
                    }
                    else{
                        matrix[i][0] = 0 ;
                    }
                }
            }
        }
        for(int i = 1 ; i < matrix.length ; i++){
            for(int k = 1 ; k < matrix[0].length ; k++){
                if( matrix[0][k] == 0 || matrix[i][0] == 0){
                    matrix[i][k] = 0;
                }
            }
        }
        if(matrix[0][0] == 0 ){
            for(int i = 0 ; i < matrix.length ; i ++){
                matrix[i][0] = 0 ;
            }
        }
        if(box1.equals(true)){
            for(int i = 0 ; i < matrix[0].length ; i++){
                matrix[0][i] = 0 ;
            }
        }
    }
}
