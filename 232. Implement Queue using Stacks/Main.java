


class MyQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int front ;
    public MyQueue() {
    }
    
    public void push(int x) {
        if(stack1.empty()){
            this.front = x ;
        }
        stack1.push(x);
    }
    
    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int top = stack2.pop();
        if(!stack2.empty()){
            this.front = stack2.peek();
        }
        else{
            this.front = 0;
        }
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return top ;
    }
    
    public int peek() {
        return this.front ;
    }
    
    public boolean empty() {
        return stack1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
