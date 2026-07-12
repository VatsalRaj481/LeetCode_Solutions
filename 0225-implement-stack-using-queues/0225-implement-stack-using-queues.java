class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue= new ArrayDeque<>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for(int i=0;i<queue.size()-1;i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        while(queue.isEmpty()){
            throw new RuntimeException("stack underflow");
        }
        return queue.poll();
    }
    
    public int top() {
        if(queue.isEmpty()){
            throw new RuntimeException("stack underflow");
        }
        return queue.peek();
    }
    
    public boolean empty() {
        if(queue.isEmpty())return true;
        return false;
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