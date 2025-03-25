class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canCut(rectangles, 0) || canCut(rectangles, 1);
    }
    private boolean canCut(int[][] rectangles, int j){
        int count = 0;
        Arrays.sort(rectangles, (a,b) -> Integer.compare(a[j], b[j]));
        int end = rectangles[0][j + 2];
        for(int i = 1; i < rectangles.length; i++){
            int[] rect = rectangles[i];
            if(end <= rect[j]){
                count++;
            }
            end = Math.max(end, rect[j + 2]);
        }
        return count >= 2;

    }
}
