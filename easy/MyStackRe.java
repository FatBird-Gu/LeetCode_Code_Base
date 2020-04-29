package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackRe {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyStack m = new MyStack();
        m.push(2);
        m.push(1);
        m.top();
        m.pop();
        m.pop();
    }

    static class MyStack {
        Queue<Integer> q1, q2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q1 = new LinkedList<Integer>();
            q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            q1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            Queue<Integer> tmp = q2;
            q2 = q1;
            q1 = tmp;
            return q2.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            Queue<Integer> tmp = q2;
            q2 = q1;
            q1 = tmp;
            int res = q2.peek();
            q1.add(q2.poll());
            return res;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
