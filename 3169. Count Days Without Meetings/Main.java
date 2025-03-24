class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> Integer.compare(a[0],b[0]));
        int head = meetings[0][0];
        int tail = meetings[0][1];
        int res = head - 1;
        for(int i = 1; i < meetings.length; i++){
            int newHead = meetings[i][0];
            int newTail = meetings[i][1];
            if(newHead > tail){
                res += newHead - tail - 1;
            }
            tail = Math.max(tail, newTail);
        }
        res += days - tail ;
        return res;
    }
}
