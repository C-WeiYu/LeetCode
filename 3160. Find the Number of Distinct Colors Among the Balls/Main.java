class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Integer> balls = new HashMap<>();
        int[] res = new int[queries.length] ;
        for(int i = 0; i < res.length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(balls.containsKey(ball)){
                int removeColor = balls.get(ball);
                balls.merge(ball, color, (a,b) -> a=b);
                if(colors.get(removeColor) == 1){
                    colors.remove(removeColor);
                }
                else{
                    colors.merge(removeColor, 1, (a,b) -> a-b);
                }
            }
            else{
                balls.put(ball, color);
            }
            colors.merge(color, 1, (a,b) -> a+b);
            res[i] = colors.size();
        }
        return res;
    }
}
