class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        int[] count = new int[10001];
        int res = 0 ;
        int mod = grid[0][0] % x ;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] % x != mod){
                    return -1;
                }
                count[grid[i][j]]++;
            }
        }
        int median = 0;
        int total = 0;
        for(int k = 0; k < count.length; k++){
            if(count[k] != 0){
                total += count[k];
                if(total >= (len+1) / 2){
                    median = k;
                    break ;
                }
            }
        }
        for(int l = 0; l <= median; l++){
            res += count[l] * (median - l) / x ;
        }
        for(int r = median+1; r < count.length; r++){
            res += count[r] * (r - median) / x ;
        }
        return res ;
    }
}
