package mid;

public class NumDecodings {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        NumDecodings n = new NumDecodings();
        System.out.println(n.numDecodings("1"));
    }

    //	public int numDecodings(String s) {
//        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
//			return 0;
//		}
//
//        char[] chs = s.toCharArray();
//
//        return process(chs, 0, 1) + process(chs, 0, 2);
//    }
//	public int process(char[] chs, int index, int tranLen) {
//		if (index + tranLen > chs.length) {
//			return 0;
//		}
//		int res = 0;
//		for(int i = 0; i<tranLen; i++) {
//			res = res*10 + (chs[index+i]-'0');
//		}
//		if (res<1 || res>26) {
//			return 0;
//		}
//		if (index + tranLen == chs.length) {
//			return 1;
//		}
//
//		return process(chs, index+tranLen, 1) + process(chs, index+tranLen, 2);
//	}
    public int numDecodings(String s) {
        int len = s.length();
        char[] chs = s.toCharArray();
        if (len == 0) {
            return 0;
        }
        if (chs[0] == '0') {
            return 0;
        }
        int dp[][] = new int[2][len];
        dp[0][0] = 1;
        dp[1][0] = 0;
        for (int i = 1; i < len; i++) {
            if (chs[i] == '0') {
                if (chs[i - 1] == '1' || chs[i - 1] == '2') {
                    dp[0][i] = 0;
                    dp[1][i] = dp[0][i - 1];
                } else {
                    return 0;
                }
            } else if (chs[i - 1] == '1' || (chs[i - 1] == '2' && chs[i] <= '6')) {
                dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
                dp[1][i] = dp[0][i - 1];
            } else {
                dp[1][i] = 0;
                dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            }
        }
        return dp[1][len - 1] + dp[0][len - 1];
    }

}
