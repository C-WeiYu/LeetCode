class Solution {
    public boolean exist(char[][] board, String word) {
        int cols = board[0].length;
        int rows = board.length;
        boolean[][] visited = new boolean[rows][cols];
        boolean ans = false ; 
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == word.charAt(0)){
                    ans = dfs(i,j,0,word,board,visited);
                }
                if (ans) return ans;
            }
        }
        return false;
    }
    private boolean dfs(int r , int c, int index, String word, char[][] board, boolean[][] visited){
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] == true || board[r][c] != word.charAt(index)){
            return false ;
        }

        visited[r][c] = true ;

        if(dfs(r-1, c, index+1, word, board, visited)||
        dfs(r+1, c, index+1, word, board, visited)||
        dfs(r, c-1, index+1, word, board, visited)||
        dfs(r, c+1, index+1, word, board, visited)){
            return true ;
        }

        visited[r][c] = false;
        return false;
    }
}
