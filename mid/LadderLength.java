package mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LadderLength {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new LadderLength().ladderLength("cog", "dot", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // visited�޸�Ϊboolean����
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            while (size-- > 0) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); ++i) {
                    // ͨ��index�ж��Ƿ��Ѿ�����
                    if (visited[i]) {
                        continue;
                    }
                    String s = wordList.get(i);
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    visited[i] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public boolean canConvert(String s1, String s2) {
        // ��Ϊ��Ŀ˵�˵��ʳ�����ͬ�����Բ����ǳ�������
        // if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }

}
