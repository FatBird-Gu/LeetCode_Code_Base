package diffi;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaximalRectangle m = new MaximalRectangle();
        System.out.println(m.maximalRectangle(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            max = Math.max(max, maxS(height));
        }
        return max;
    }

    public int maxS(int[] height) {
        Stack<Integer> st = new Stack<>();
        int maxS = 0;
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                int out = st.pop();
                int k = st.isEmpty() ? -1 : st.peek();
                int curS = (i - k - 1) * height[out];
                maxS = Math.max(maxS, curS);
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int out = st.pop();
            int k = st.isEmpty() ? -1 : st.peek();
            int curS = (height.length - k - 1) * height[out];
            maxS = Math.max(maxS, curS);
        }
        return maxS;
    }

}
