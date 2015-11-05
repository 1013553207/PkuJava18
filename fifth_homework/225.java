class MyStack {
    // Push element x onto stack.
    public void push(int v) {
        list.addFirst(v);
    }
    public int top() {
        return (Integer)list.getFirst();
    }
    public void pop() {
        list.removeFirst();
    }
    public boolean empty() {
        return list.size()>0 ? false:true;
    }
    private LinkedList list = new LinkedList<Integer>();
}