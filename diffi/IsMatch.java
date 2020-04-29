package diffi;

public class IsMatch {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IsMatch i = new IsMatch();
        System.out.println(i.isMatch("aab", "c*a*b"));
        System.out.println(i.isMatchdp("aab", "c*a*b"));
    }

    public boolean isMatchdp(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        if (!isValid(ss, pp)) {
            return false;
        }
        boolean dp[][] = initializeDp(ss, pp);
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 2; j >= 0; j--) {
                if (pp[j + 1] != '*') {
                    dp[i][j] = (ss[i] == pp[j] || pp[j] == '.')
                            && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si < ss.length && (ss[si] == pp[j] || pp[j] == '.')) {
                        if (dp[si][j + 2]) {
                            dp[i][j] = true;
                        }
                        si++;
                    }
                    if (dp[i][j] != true) {
                        dp[i][j] = dp[si][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    public boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length) {
            return si == s.length;
        }
        if (ei + 1 == e.length || e[ei + 1] != '*') {
            return si != s.length && (s[si] == e[ei] || e[ei] == '.')
                    && process(s, e, si + 1, ei + 1);
        }
        while (si < s.length && (s[si] == e[ei] || e[ei] == '.')) {
            if (process(s, e, si, ei + 2)) {
                return true;
            }
            si++;
        }
        return process(s, e, si, ei + 2);
    }

    public boolean[][] initializeDp(char[] s, char[] p) {
        boolean[][] dp = new boolean[s.length + 1][p.length + 1];
        dp[s.length][p.length] = true;
        if (s.length > 0 && p.length > 0) {
            if (s[s.length - 1] == p[p.length - 1] || p[p.length - 1] == '.') {
                dp[s.length - 1][p.length - 1] = true;
            }
        }
        for (int i = p.length - 2; i >= 0; i -= 2) {
            if (p[i + 1] == '*' && p[i] != '*') {
                dp[s.length][i] = true;
            } else {
                break;
            }
        }
        return dp;
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        if (!isValid(ss, pp)) {
            return false;
        }
        return process(ss, pp, 0, 0);
    }

    public boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

}
