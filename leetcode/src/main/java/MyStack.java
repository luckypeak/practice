import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> fqueue;
    Queue<Integer> squeue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.fqueue = new LinkedList<>();
        this.squeue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        fqueue.add(x);
        return;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return 1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return 1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return fqueue.isEmpty();
    }
}