package mid;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
//	public List<String> generateParenthesis(int n) {
//        if (n<=0) {
//			return new ArrayList<String>();
//		}
//        List<String> ls = new ArrayList<>();
//        process("(", ls, n);
//        return ls;
//    }
//	public void process(String s, List<String> ls, int n) {
//		if (s.length() == 2*n) {
//			if (this.isValid(s)) {
//				ls.add(s);
//			}
//			return;
//		}
//		process(s+"(", ls, n);
//		process(s+")",ls,n);
//	}
//	public boolean isValid(String s) {
//		if (s == null || s.length() == 0) {
//			return true;
//		}
//        char[] chs = s.toCharArray();
//        Stack<Character> st = new Stack<>();
//        for (int i = 0; i < chs.length; i++) {
//        	st.add(chs[i]);
//			if (chs[i] == '(' || chs[i] == '{' || chs[i] == '[') {
//				continue;
//			}else {
//				char cs = st.pop();
//				char ch = st.isEmpty()?0:st.peek();
//				if (cs == ')' && ch =='(') {
//					st.pop();
//				}else if (cs == ']' && ch =='[') {
//					st.pop();
//				}else if (cs == '}' && ch =='{') {
//					st.pop();
//				}else {
//					st.add(cs);
//				}
//			}
//		}
//        return st.isEmpty();
//    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GenerateParenthesis22 g = new GenerateParenthesis22();
        List<String> ls = g.generateParenthesis(3);
        for (String str : ls) {
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    public void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) {
            return;
        }
        if (count1 == n && count2 == n) {
            res.add(ans);
            return;
        }
        if (count1 >= count2) {
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans + ")", count1, count2 + 1, n);
        }

    }

}
