package easy;

import java.util.Stack;

public class AddBinary {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("", ""));
	}

	public String addBinary(String a, String b) {
		char[] s1 = a.toCharArray();
		char[] s2 = b.toCharArray();
		int len1 = s1.length - 1;
		int len2 = s2.length - 1;
		int flag = 0;
		String res = "";
		Stack<Integer> st = new Stack<Integer>();
		while (len1 >= 0 && len2 >= 0) {
			int t = s1[len1] + s2[len2] - 2 * '0' + flag;
			flag = t / 2;
			st.add(t % 2);
			len1--;
			len2--;
		}
		while (len1 >= 0) {
			int t = s1[len1] - '0' + flag;
			flag = t / 2;
			st.add(t % 2);
			len1--;
		}
		while (len2 >= 0) {
			int t = s2[len2] - '0' + flag;
			flag = t / 2;
			st.add(t % 2);
			len2--;
		}
		if (flag == 1) {
			st.add(flag);
		}
		while (!st.isEmpty()) {
			res = res + String.valueOf(st.pop());
		}
		return res;
	}

}
