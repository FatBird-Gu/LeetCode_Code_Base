package mid;

public class StringToInt {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int index = 0;
        boolean isPos = true;
        while (index < chs.length) {
            if (chs[index] == ' ') {
                index++;
                continue;
            }
            if (chs[index] == '-') {
                isPos = false;
                index++;
                break;
            } else if ((chs[index] >= '0' && chs[index] <= '9')) {
                isPos = true;
                break;
            } else if (chs[index] == '+') {
                isPos = true;
                index++;
                break;
            } else {
                return 0;
            }
        }
        if (index == chs.length) {
            return 0;
        }
        long res = 0;
        while (index < chs.length && chs[index] >= '0' && chs[index] <= '9') {

            res = res * 10 + (chs[index] - '0');
            long tmp = isPos ? res : -res;
            if (tmp != (int) tmp)
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            index++;
        }
        res = isPos ? res : -res;
        return (int) res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int i = 1283472332;
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(myAtoi("2147483648"));
    }

}
