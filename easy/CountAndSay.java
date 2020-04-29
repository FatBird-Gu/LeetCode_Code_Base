package easy;

public class CountAndSay {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        String str = "1";
        String res = "1";
        while (n > 1) {
            res = "";
            int count = 1;
            for (int i = 0; i < str.length(); i++) {
                int end = i + 1;
                while (end < str.length() && str.charAt(end) == str.charAt(i)) {
                    count++;
                    end++;
                }

                i = end - 1;
                res = res + count + str.charAt(i);
                count = 1;
            }
            str = res;

            n--;
        }
        return res;
    }
}