class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length ;
        int[] temp = new int[len * len + 1];
        int[] res = new int[2];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(temp[grid[i][j]] != 0){
                    res[0] = grid[i][j];
                }
                else{
                    temp[grid[i][j]] = grid[i][j];
                }
            }
        }
        for(int i = 1 ; i < temp.length ; i++){
            if(temp[i] == 0){
                res[1] = i;
            }
        }
        return res ;
    }
}
