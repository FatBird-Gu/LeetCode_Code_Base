package easy;

public class LongesCommon {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"asd"}));
        ;
    }

    public static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            int index = 0;
            boolean flag = true;
            String res = "";
            while (flag) {
                char cmp;
                if (index < strs[0].length()) {
                    cmp = strs[0].charAt(index);
                } else {
                    flag = false;
                    continue;
                }

                for (int i = 1; i < strs.length; i++) {
                    if (index >= strs[i].length() || cmp != strs[i].charAt(index)) {
                        flag = false;
                    }
                }
                if (flag) {
                    res = res + cmp;
                }
                index++;
            }
            return res;
        }
    }

}
