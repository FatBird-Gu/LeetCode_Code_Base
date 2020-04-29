package easy;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        st1.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!st2.isEmpty()) {
            return st2.pop();
        } else {
            while (!st1.isEmpty()) {
                st2.add(st1.pop());
            }
            return st2.pop();
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!st2.isEmpty()) {
            return st2.peek();
        } else {
            while (!st1.isEmpty()) {
                st2.add(st1.pop());
            }
            return st2.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (st1.isEmpty() && st2.isEmpty()) {
            return true;
        }
        return false;
    }

}
