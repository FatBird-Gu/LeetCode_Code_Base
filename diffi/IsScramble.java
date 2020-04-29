package diffi;

public class IsScramble {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] letter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letter[s1.charAt(i) - 'a']++;
            letter[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] != 0) {
                return false;
            }
        }
        int end = s1.length();
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(end - i))
                    && isScramble(s1.substring(i), s2.substring(0, end - i))) {
                return true;
            }
        }
        return false;
    }

}
