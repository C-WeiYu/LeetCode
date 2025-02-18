class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> monotonicQueue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            // 加入的數字比當前queue中後n個數字都大時，把後面n個數直接刪掉
            while(!monotonicQueue.isEmpty() && num > monotonicQueue.peekLast()){
                monotonicQueue.pollLast();
            }
            monotonicQueue.offerLast(num);

            // 當目前加入的數的index已經大於等於k，表示window已滿
            // 如果Queue中最左邊的數等於nums[i-k]，即表示這個數在目前window範圍以外，應此刪掉
            if(i >= k && monotonicQueue.peek() == nums[i-k]){
                monotonicQueue.poll();
            }
            
            // 當window開始滿時，每次取最左邊(最大)的值
            if(i >= k-1){
                res[i-k+1] = monotonicQueue.peek();
            }
        }    
        return res ;     
    }
}
