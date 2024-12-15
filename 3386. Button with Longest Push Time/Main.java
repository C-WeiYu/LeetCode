class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxTime = events[0][1] ;
        int button = events[0][0] ;
        for(int i = 1 ; i < events.length ; i++){
            if(events[i][1]-events[i-1][1] > maxTime){
                maxTime = events[i][1]-events[i-1][1];
                button = events[i][0];
            }
            else if(events[i][1]-events[i-1][1] == maxTime){
                button = Math.min(button, events[i][0]);
            }
        }
        return button;    
    }
}
