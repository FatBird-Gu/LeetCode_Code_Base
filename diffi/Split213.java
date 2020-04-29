package diffi;

public class Split213 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.shortestPalindrome("aacecaaa"));
        ;
    }

    public static class Solution {
        public char[] manacher(String s) {
            char[] charArray = s.toCharArray();
            char[] array = new char[2 * charArray.length + 1];
            int index = 0;
            for (int i = array.length - 1; i > -1; i--) {
                array[i] = (i & 1) == 0 ? '#' : charArray[index++];
            }
            return array;
        }

        public String shortestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] charArray = manacher(s);
            int[] pChar = new int[charArray.length];
            int C = -1;
            int R = -1;
            for (int i = 0; i < pChar.length; i++) {
                pChar[i] = i < R ? Math.min(pChar[2 * C - i], R - i) : 1;
                while (i - pChar[i] > -1 && i + pChar[i] < charArray.length) {
                    if (charArray[i - pChar[i]] == charArray[i + pChar[i]]) {
                        pChar[i]++;
                    } else {
                        break;
                    }
                }
                if (i + pChar[i] > R) {
                    C = i;
                    R = i + pChar[i];
                }
                if (R == pChar.length) {
                    break;
                }
            }
            R = C - pChar[C];
            String res = "";
            for (int i = 0; i < pChar.length; i++) {
                if (charArray[i] != '#') {
                    res = res + String.valueOf(charArray[i]);
                }
            }
            for (int i = R; i > 0; i--) {
                if (charArray[i] != '#') {
                    res = res + String.valueOf(charArray[i]);
                }
            }
            return res;
        }
    }

}
