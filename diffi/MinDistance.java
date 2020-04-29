package diffi;

public class MinDistance {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinDistance m = new MinDistance();
        System.out.println(m.minDistance("intention", ""));
    }

    //	public int minDistance(String word1, String word2) {
//        if (word1 == null || word2 == null) {
//			return 0;
//		}
//        char[] w1 = word1.toCharArray();
//        char[] w2 = word2.toCharArray();
//        return process(w1, w2, 0, 0);
//    }
//
//	public int process(char[] w1, char[] w2, int i, int j) {
//		if (i == w1.length || j == w2.length) {
//			return Math.max(w1.length - i, w2.length - j);
//		}
//		if (w1[i] == w2[j]) {
//			return process(w1, w2, i+1, j+1);
//		}
//		return Math.min(process(w1, w2, i+1, j+1), Math.min(process(w1, w2, i+1, j), process(w1, w2, i, j+1))) + 1;
//	}
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int dp[][] = new int[w1.length + 1][w2.length + 1];
        for (int i = w2.length - 1; i >= 0; i--) {
            dp[w1.length][i] = w2.length - i;
        }
        for (int i = w1.length - 1; i >= 0; i--) {
            dp[i][w2.length] = w1.length - i;
        }
        for (int i = w1.length - 1; i >= 0; i--) {
            for (int j = w2.length - 1; j >= 0; j--) {
                if (w1[i] == w2[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j + 1], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
