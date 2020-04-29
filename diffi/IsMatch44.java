package diffi;

public class IsMatch44 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IsMatch44 i = new IsMatch44();
        System.out.println(i.isMatch("", "*"));
    }

    //	public boolean isMatch(String s, String p) {
//        if (s == null || p == null) {
//			return  false;
//		}
//        char[] ss = s.toCharArray();
//        char[] e = p.toCharArray();
//        return process(ss, e, 0, 0);
//    }
//	public boolean process(char[]s, char[] e, int si, int ei) {
//		if (si == s.length) {
//			while(ei < e.length && e[ei] == '*') {
//				ei++;
//			}
//			return ei==e.length;
//		}
//		if (ei == e.length) {
//			return si == s.length;
//		}
//		if (s[si] != e[ei] && e[ei] != '*' && e[ei] != '?') {
//			return false;
//		}
//		if (s[si] == e[ei] || e[ei] == '?') {
//			return process(s, e, si+1, ei+1);
//		}
//		while(si<s.length && e[ei] == '*') {
//			if (process(s, e, si, ei+1)) {
//				return true;
//			}
//			si++;
//		}
//		return process(s, e, si, ei+1);
//	}
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] e = p.toCharArray();
        boolean[][] dp = initializeDp(ss, e);
        for (int si = ss.length - 1; si >= 0; si--) {
            for (int ei = e.length - 1; ei >= 0; ei--) {
                if (ss[si] != e[ei] && e[ei] != '*' && e[ei] != '?') {
                    dp[si][ei] = false;
                } else {
                    if (ss[si] == e[ei] || e[ei] == '?') {
                        dp[si][ei] = dp[si + 1][ei + 1];
                    } else {
                        int tmpsi = si;
                        while (tmpsi < ss.length && e[ei] == '*') {
                            if (dp[tmpsi][ei + 1]) {
                                dp[si][ei] = true;
                            }
                            tmpsi++;
                        }
                        if (dp[si][ei] != true) {
                            dp[si][ei] = dp[tmpsi][ei + 1];
                        }
                    }
                }
            }
        }
        return dp[0][0];
    }

    public boolean[][] initializeDp(char[] s, char[] e) {
        boolean[][] dp = new boolean[s.length + 1][e.length + 1];
        dp[s.length][e.length] = true;
        for (int i = e.length - 1; i >= 0 && e[i] == '*'; i--) {
            dp[s.length][i] = true;
        }
        return dp;
    }

}
