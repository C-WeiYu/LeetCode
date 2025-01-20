class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> pos = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        int[][] newMat = new int[row+1][col+1];
        for(int i = 0 ; i < row ; i++){
            int rowSum = 0 ;
            for(int j = 0 ; j < col ; j++){
                newMat[i][j] = mat[i][j];
                pos.put(mat[i][j],new int[]{i,j});
                rowSum += mat[i][j];
            }
            newMat[i][col+1-1] = rowSum;
        }
        for(int i = 0 ; i < col ; i++){
            int colSum = 0;
            for(int j = 0 ; j < row ; j++){
                colSum += mat[j][i];
            }
            newMat[row+1-1][i] = colSum;
        }

        for(int i = 0 ; i < arr.length ; i++){
            int posRow = pos.get(arr[i])[0];
            int posCol = pos.get(arr[i])[1];
            newMat[posRow][col+1-1] -= arr[i];
            newMat[row+1-1][posCol] -= arr[i];
            if(newMat[posRow][col+1-1]==0 || newMat[row+1-1][posCol] ==0){
                return i ;
            }
        }
        return  -1 ;
    }
}
