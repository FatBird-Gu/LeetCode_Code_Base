package easy;

import java.util.Stack;

public class Valid20 {
    public static void main(String[] args) {
        Valid20 v = new Valid20();
        System.out.println(v.isValid("[{()}]"));
        System.out.println(v.isValid(""));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            st.add(chs[i]);
            if (chs[i] == '(' || chs[i] == '{' || chs[i] == '[') {
                continue;
            } else {
                char cs = st.pop();
                char ch = st.isEmpty() ? 0 : st.peek();
                if (cs == ')' && ch == '(') {
                    st.pop();
                } else if (cs == ']' && ch == '[') {
                    st.pop();
                } else if (cs == '}' && ch == '{') {
                    st.pop();
                } else {
                    st.add(cs);
                }
            }
        }
        return st.isEmpty();
    }
}
