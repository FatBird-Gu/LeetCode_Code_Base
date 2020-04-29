package mid;

import java.util.ArrayList;
import java.util.List;

public class groupAnagrams {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        groupAnagrams g = new groupAnagrams();
        g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> ls = new ArrayList<>();


        boolean visited[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<String> tmp = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                if (!visited[j] && isSame(strs[i], strs[j])) {
                    tmp.add(strs[j]);
                    visited[j] = true;
                }
            }
            ls.add(tmp);
        }
        return ls;
    }

    public boolean isSame(String o1, String o2) {
        if (o1.length() != o2.length()) {
            return false;
        }
        int count[] = new int[26];
        for (int i = 0; i < o1.length(); i++) {
            count[o1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < o2.length(); i++) {
            count[o2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
