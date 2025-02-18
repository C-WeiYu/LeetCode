class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> monotonicQueue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            while(!monotonicQueue.isEmpty() && num > monotonicQueue.peekLast()){
                monotonicQueue.pollLast();
            }
            monotonicQueue.offerLast(num);

            if(i >= k && monotonicQueue.peek() == nums[i-k]){
                monotonicQueue.poll();
            }

            if(i >= k-1){
                res[i-k+1] = monotonicQueue.peek();
            }
        }    
        return res ;     
    }
}
