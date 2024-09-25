class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0 ;
        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    ans += 1;
                }
            }
        }
        return ans;
    }
    private void dfs(char[][]grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return ;
        }
        if(grid[row][col] == '0' ) {
            return ;
        }
        grid[row][col] = '0';
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
    }
}
