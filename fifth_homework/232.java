class MyQueue {
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> tmp_stack = new Stack<Integer>();
        while(true){
            if(stack.empty()) break;
            tmp_stack.push(stack.pop());
        }
        tmp_stack.pop();
        while(true){
            if(tmp_stack.empty()) break;
            stack.push(tmp_stack.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> tmp_stack = new Stack<Integer>();
        while(true){
            if(stack.empty()) break;
            tmp_stack.push(stack.pop());
        }
        int key = tmp_stack.peek();
        while(true){
            if(tmp_stack.empty()) break;
            stack.push(tmp_stack.pop());
        }
        return  key;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
    Stack<Integer> stack = new Stack<Integer>();
}