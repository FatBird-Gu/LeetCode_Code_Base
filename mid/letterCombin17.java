package mid;

import java.util.ArrayList;
import java.util.List;

public class letterCombin17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.letterCombinations("6547"));
	}

	public static class Solution {
		public String[] strs = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

		public List<String> letterCombinations(String digits) {
			if (digits == null || digits.length() == 0) {
				return new ArrayList<>();
			}
			List<String> list = new ArrayList<>();
			process(digits.toCharArray(), 0, list, "");
			return list;
		}

		public void process(char[] digits, int index, List<String> ls, String str) {
			if (index == digits.length) {
				ls.add(str);
				return;
			}
			int num = digits[index] - '2';
			for (int i = 0; i < strs[num].length(); i++) {
				process(digits, index + 1, ls, str + strs[num].charAt(i));
			}
		}
	}

}
