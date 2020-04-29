package mid;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        LargestRectangleArea l = new LargestRectangleArea();
        System.out.println(l.largestRectangleArea(new int[]{}));
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int t = st.pop();
                int h = heights[t];
                int l = st.isEmpty() ? -1 : st.peek();
                max = Math.max(max, (i - l - 1) * h);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int t = st.pop();
            int h = heights[t];
            int l = st.isEmpty() ? -1 : st.peek();
            max = Math.max(max, (heights.length - l - 1) * h);
        }
        return max;
    }
}
