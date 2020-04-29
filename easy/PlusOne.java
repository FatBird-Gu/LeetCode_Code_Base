package easy;

public class PlusOne {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int flag = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i] = flag + 1 + digits[i];
            } else {
                digits[i] = flag + digits[i];
            }
            flag = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        int[] res;
        if (flag == 0) {
            return digits;
        } else {
            res = new int[digits.length + 1];
            res[0] = flag;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
        }
        return res;
    }

}
