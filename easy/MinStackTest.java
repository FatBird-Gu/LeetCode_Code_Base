package easy;

import java.util.Stack;

public class MinStackTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    class MinStack {
        final static int MIN = Integer.MAX_VALUE;
        Stack<Integer> stack;
        Stack<Integer> minS;
        int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minS = new Stack<>();
            min = MIN;
        }

        public void push(int x) {
            stack.push(x);
            if (min > x) {
                min = x;
            }
            minS.push(min);
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minS.pop();
                min = minS.isEmpty() ? MIN : minS.peek();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minS.peek();
        }
    }

}
