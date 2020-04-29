package diffi;

public class IsInterleave {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new IsInterleave().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int r = s1.length();
        int c = s2.length();

        boolean[][] dp = new boolean[r+1][c+1];
        dp[r][c] = true;
        for (int i = s2.length()-1; i >=0; i--) {
            if (s2.charAt(i) == s3.charAt(r + i)) {
                dp[r][i] = true;
            }else {
                break;
            }
        }
        for (int i = s1.length()-1; i >= 0; i--) {
            if (s1.charAt(i) == s3.charAt(c + i)) {
                dp[i][c] = true;
            }else {
                break;
            }
        }
        for (int i = r-1; i >=0; i--) {
            for (int j = c-1; j >= 0; j--) {
                char port = s3.charAt(i+j);
                if (s1.charAt(i) == port && s2.charAt(j) == port) {
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                }else if (s1.charAt(i) == port) {
                    dp[i][j] = dp[i+1][j];
                }else if(s2.charAt(j) == port){
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }*/
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
