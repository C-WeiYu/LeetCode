class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int len = grid.length;
        for(int i = 1; i < grid.length; i++){
            topRight(len, 0, i, grid);
        }
        for(int j = 0; j < grid.length; j++){
            bottomLeft(len, j, 0, grid);
        }
        return grid;
    }

    private void bottomLeft(int len, int x, int y, int[][] grid){
        int[] sortArray = new int[len - x];
        int tempX = x;
        int tempY = y;
        while(tempX < len){
            sortArray[tempY] = grid[tempX][tempY];
            tempX++;
            tempY++;
        }
        Arrays.sort(sortArray);
        System.out.println(Arrays.toString(sortArray));
        while(y < sortArray.length){
            grid[x][y] = sortArray[sortArray.length-1-y];
            x++;
            y++;
        }
    }

    private void topRight(int len, int x, int y, int[][] grid){
        int[] sortArray = new int[len - y];
        int tempX = x;
        int tempY = y;
        while(tempY < len){
            sortArray[tempX] = grid[tempX][tempY];
            tempX++;
            tempY++;
        }
        Arrays.sort(sortArray);
        while(x < sortArray.length){
            grid[x][y] = sortArray[x];
            x++;
            y++;
        }
    }

}
