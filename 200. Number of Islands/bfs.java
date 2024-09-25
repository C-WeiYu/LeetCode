class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0 ;
        int rows = grid.length;
        int columns = grid[0].length;
        Set<String> visited = new HashSet<>();

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < columns ; c++){
                if(grid[r][c] == '1' && !visited.contains(r +","+ c)){
                    bfs(grid, r, c, visited, directions);
                    ans += 1;
                }
            }
        }
        return ans;
    }
    private void bfs(char[][]grid, int row, int col, Set<String> visited, int[][] directions){
        Queue<int[]> queue = new LinkedList<>();
        visited.add(row + "," + col);
        queue.add(new int[]{row, col});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] direction : directions){
                int newRow = r + direction[0];
                int newCol = c + direction[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == '1' && !visited.contains(newRow + "," + newCol)){
                    queue.add(new int[] {newRow, newCol});
                    visited.add(newRow + "," + newCol);
                }
            }
        }
    }
}
