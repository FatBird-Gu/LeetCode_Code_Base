package diffi;

import java.util.ArrayList;
import java.util.List;

public class FindSubstring30 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSubstring30 f = new FindSubstring30();
		List<Integer> ls = f.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"});
		for (int t : ls) {
			System.out.println(t);
		}
	}

	public List<Integer> findSubstring(String s, String[] words) {
		if (words == null || words.length == 0 || s == null || s.length() == 0) {
			return new ArrayList<Integer>();
		}
		int wordLen = words[0].length();
		int strLen = s.length();
		List<Integer> res = new ArrayList<>();
		if (strLen < wordLen * words.length) {
			return new ArrayList<Integer>();
		}

		int L = 0;
		int R = words.length * wordLen;
		while (R <= s.length()) {
			// valid the String [L-R)
			boolean[] valid = new boolean[words.length];
			int count = 0;
			int index = L;
			for (int k = 1; k <= words.length; k++) {
				String str = s.substring(index + (k - 1) * wordLen, index + k * wordLen);
				for (int i = 0; i < words.length; i++) {
					if (str.equals(words[i]) && valid[i] == false) {
						valid[i] = true;
						count++;
						break;
					}
				}
			}
			if (count == words.length) {
				res.add(L);
			}
			L++;
			R++;
		}
		return res;
	}

}
