class MinStack {
	node head;
 
	public void push(int x) {
	    node m = new node(x);
		if (head == null)
			head = m;
		else {
		    if (head.min < x) m.min = head.min;
			m.next = head;
			head = m;
		}
	}
 
	public void pop() {
		if (head == null) return;
		else head = head.next;
	}
 
	public int top() {
		if (head == null) return Integer.MAX_VALUE;
		else return head.val;
	}
 
	public int getMin() {
		if (head == null) return Integer.MAX_VALUE;
		else return head.min;
	}
}

class node {
	int val;
	int min;
	node next;
	node (int n) {
		val = n;
		min = n;
		next = null;
	}
}
