class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights.length == 0 || heights[0].length==0){
            return ans;
        } 

        int rows = heights.length;
        int columns = heights[0].length;
        boolean [][] pac = new boolean[rows][columns];
        boolean [][] alt = new boolean[rows][columns];

        for(int row = 0 ; row < rows ; row++){
            dfs(row, 0, pac, heights[row][0], heights);
            dfs(row, columns-1, alt, heights[row][columns-1], heights);
        }

        for(int column = 0 ; column < columns ; column++){
            dfs(0, column, pac, heights[0][column], heights);
            dfs(rows-1, column, alt, heights[rows-1][column], heights);
        }
        
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < columns ; c++){
                if(pac[r][c] && alt[r][c]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(r);
                    temp.add(c);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

        private void dfs(int row, int column, boolean[][] visit, int preHeight, int[][] heights){
            if(row < 0 || column < 0 || row == heights.length || column == heights[0].length || visit[row][column] || preHeight > heights[row][column]){
                return ;
            }
            visit[row][column] = true ;
            dfs(row+1, column, visit, heights[row][column], heights);
            dfs(row, column+1, visit, heights[row][column], heights);
            dfs(row-1, column, visit, heights[row][column], heights);
            dfs(row, column-1, visit, heights[row][column], heights);

    }
}
