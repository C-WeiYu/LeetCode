class MyStack {
    private Queue<Integer> queue1 ;
    private Queue<Integer> queue2 ;
    int top ;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        this.top = x ;
        while(queue1.peek() != null){
            queue2.offer(queue1.poll());
        }
        queue1.offer(x);
        while(queue2.peek() != null){
            queue1.offer(queue2.poll());
        }
    }
    
    public int pop() {
        while(queue1.peek() != null){
            queue2.offer(queue1.poll());
        }
        int res = queue2.poll();
        this.top = queue2.peek()!= null?queue2.peek():-1;
        while(queue2.peek() != null){
            queue1.offer(queue2.poll());
        }
        return res ;
    }
    
    public int top() {
        return top ;
    }
    
    public boolean empty() {
        return queue1.peek() == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
