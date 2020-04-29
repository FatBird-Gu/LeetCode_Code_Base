package easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LengthOfLastWord t = new LengthOfLastWord();
        System.out.println(t.lengthOfLastWord("123   14 "));
        ;
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i >= 0; i++) {
            if (strs[i].length() >= 1) {
                return strs[i].length();
            }
        }
        return 0;
    }

}
