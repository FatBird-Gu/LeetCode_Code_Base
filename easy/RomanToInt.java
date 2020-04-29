package easy;

public class RomanToInt {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RomanToInt r = new RomanToInt();
        System.out.println(r.romanToInt("CMC"));

    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'I') {
                if (i + 1 < chs.length && chs[i + 1] == 'V') {
                    res += 4;
                    i = i + 1;
                    continue;
                }
                if (i + 1 < chs.length && chs[i + 1] == 'X') {
                    res += 9;
                    i = i + 1;
                    continue;
                }
                res += 1;
            }
            if (chs[i] == 'X') {
                if (i + 1 < chs.length && chs[i + 1] == 'L') {
                    res += 40;
                    i = i + 1;
                    continue;
                }
                if (i + 1 < chs.length && chs[i + 1] == 'C') {
                    res += 90;
                    i = i + 1;
                    continue;
                }
                res += 10;
            }
            if (chs[i] == 'C') {
                if (i + 1 < chs.length && chs[i + 1] == 'D') {
                    res += 400;
                    i = i + 1;
                    continue;
                }
                if (i + 1 < chs.length && chs[i + 1] == 'M') {
                    res += 900;
                    i = i + 1;
                    continue;
                }
                res += 100;
            }
            if (chs[i] == 'V') {
                res += 5;
            }
            if (chs[i] == 'L') {
                res += 50;
            }
            if (chs[i] == 'D') {
                res += 500;
            }
            if (chs[i] == 'M') {
                res += 1000;
            }
        }
        return res;
    }

}
