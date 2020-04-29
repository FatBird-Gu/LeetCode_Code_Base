package easy;

public class StrStr28 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StrStr28 s = new StrStr28();
        System.out.println(s.strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNext(s2);
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == s2.length ? i1 - i2 : -1;
    }

    public int[] getNext(char[] chs) {
        if (chs.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int index = 2;
        while (index < chs.length) {
            if (chs[index - 1] == chs[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

}
