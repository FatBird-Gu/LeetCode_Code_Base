package mid;

public class IntToRoman {
    public String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public int[] intArr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IntToRoman i = new IntToRoman();
        System.out.println(i.intToRoman(0));
    }

    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        String res = "";
        while (num != 0) {
            for (int i = 0; i < intArr.length; i++) {
                if (num - intArr[i] >= 0) {
                    res += strs[i];
                    num -= intArr[i];
                    break;
                }
            }
        }
        return res;
    }

}
