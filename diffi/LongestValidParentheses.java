package diffi;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(()"));
    }

    //	public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push('(');
//            } else if (!stack.empty() && stack.peek() == '(') {
//                stack.pop();
//            } else {
//                return false;
//            }
//        }
//        return stack.empty();
//    }
//    public int longestValidParentheses(String s) {
//        int maxlen = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i + 2; j <= s.length(); j+=2) {
//                if (isValid(s.substring(i, j))) {
//                    maxlen = Math.max(maxlen, j - i);
//                }
//            }
//        }
//        return maxlen;
//    }
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    max = Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }

}
