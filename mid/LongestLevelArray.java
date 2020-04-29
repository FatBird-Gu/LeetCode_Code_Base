package mid;

public class LongestLevelArray {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("b"));
    }

    public static class Solution {
        public char[] manacherString(String s) {
            char[] sArray = s.toCharArray();
            char[] charArray = new char[2 * sArray.length + 1];
            int index = 0;
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (i & 1) == 0 ? '#' : sArray[index++];
            }
            return charArray;
        }

        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            char[] array = manacherString(s);
            int[] pArr = new int[array.length];
            int C = -1;
            int R = -1;
            int maxIndex = 0;
            int maxLen = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                pArr[i] = i < R ? Math.min(pArr[2 * C - i], R - i) : 1;
//	        	pArr[i] = R<=i?1:Math.min(pArr[2*C-i], R-i);
                while (i + pArr[i] < array.length && i - pArr[i] > -1) {
                    if (array[i + pArr[i]] == array[i - pArr[i]]) {
                        pArr[i]++;
                    } else {
                        break;
                    }
                }
                if (i + pArr[i] > R) {
                    C = i;
                    R = i + pArr[i];
                }
                if (maxLen < pArr[i]) {
                    maxLen = pArr[i];
                    maxIndex = i;
                }
            }
            maxLen--;
            char[] Rarray = new char[maxLen];
            int index = 0;
            for (int i = maxIndex - pArr[maxIndex] + 1; i < maxIndex + pArr[maxIndex]; i++) {
                if (array[i] != '#') {
                    Rarray[index++] = array[i];
                }
            }
            return String.valueOf(Rarray);
        }
    }

}
