package mid;

import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SimplifyPath().simplifyPath("/..."));
    }

    public String simplifyPath(String path) {
        LinkedList<String> queue = new LinkedList<String>();
        int start = 0;
        char[] chs = path.toCharArray();
        while (start < chs.length) {
            int end = start;
            if (chs[start] == '/') {
                start++;
                continue;
            } else if (chs[start] == '.') {
                end = searchWord(chs, start);
                if (end - start == 2 && !queue.isEmpty()) {
                    queue.pollLast();
                }
                if (end - start > 2) {
                    queue.offer(path.substring(start, end));
                }
                start = end;
            } else {
                end = searchWord(chs, start);
                String word = path.substring(start, end);
                queue.offer(word);
                start = end;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append('/');
            sb.append(queue.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public int searchWord(char[] chs, int start) {
        while (start < chs.length) {
            if (chs[start] == '/') {
                return start;
            }
            start++;
        }
        return start;
    }

}
