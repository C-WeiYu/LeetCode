class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            if(newInterval[1] < intervals[i][0]){
                ans.add(newInterval);
                for(int k = i ; k < intervals.length ; k++){
                    ans.add(intervals[k]);
                }
                return ans.toArray(new int[ans.size()][]);
            }
            else if(newInterval[0]>intervals[i][1]){
                ans.add(intervals[i]);
            }
            else{
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
