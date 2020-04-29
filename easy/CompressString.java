package easy;

import java.util.HashMap;

public class CompressString {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new CompressString().compressString("abcfffff"));
        HashMap<String, String> m = new HashMap<>();
        m.put(null, "12");
        m.put(null, "132");
        System.out.println(m.get(null));
        System.out.println(Math.ceil(1.0 / 4));
    }

    public String compressString(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        if (S.length() < 2) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int cur = 0;
        while (cur < S.length()) {
            int count = 0;
            sb.append(S.charAt(start));
            while (cur < S.length() && S.charAt(cur) == S.charAt(start)) {
                cur++;
                count++;
            }
            sb.append(count);
            if (sb.length() >= S.length()) {
                return S;
            }
            start = cur;
        }
        return sb.toString();
    }

}
