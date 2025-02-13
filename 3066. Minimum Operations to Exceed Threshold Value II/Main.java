class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0 ;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(num < k){
                pq.offer(num);
            }
        }
        while(!pq.isEmpty()){
            int x = pq.poll();
            res++ ;
            if(pq.peek() == null){
                break ;
            }
            int y = pq.poll();
            long newVal = 2L * Math.min(x, y) + Math.max(x, y);
            if(newVal < k){
                pq.offer((int) newVal);
            }
        }
        return res ;
    }
}
