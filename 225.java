class MyStack {
  private Queue<Integer> q1 = new LinkedList<Integer>();
  private Queue<Integer> q2 = new LinkedList<Integer>();
  // Push element x onto stack.
  public void push(int x) {
    if (!q1.isEmpty()) {
      q1.add(x);
    } else {
      q2.add(x);
    }
  }
  // Removes the element on top of the stack.
  public void pop() {
    if (!q1.isEmpty()) {
      while(q1.size()>1) {
        int val = q1.poll();
        q2.add(val);
      }
      q1.poll();
      return;
    }
    if (!q2.isEmpty()) {
      while(q2.size()>1) {
        int val = q2.poll();
        q1.add(val);
      }
      q2.poll();
      return;
    }
  }
  // Get the top element.
  public int top() {
    if (!q1.isEmpty()) {
      int val = 0;
      while(!q1.isEmpty()) {
        val = q1.poll();
        q2.add(val);
      }
      return val;
    }
    if (!q2.isEmpty()) {
      int val = 0;
      while(!q2.isEmpty()) {
        val = q2.poll();
        q1.add(val);
      }
      return val;
    }
    return 0; // invalid
  }
  // Return whether the stack is empty.
  public boolean empty() {
    return q1.isEmpty() && q2.isEmpty();
  }
}