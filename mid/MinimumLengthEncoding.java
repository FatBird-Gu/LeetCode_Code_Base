package mid;

import java.util.Arrays;

public class MinimumLengthEncoding {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MinimumLengthEncoding().minimumLengthEncoding(new String[]{
                "lab", "alab"
        }));
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // �ȶԵ����б���ݵ��ʳ����ɳ���������
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // ���ʲ���trie�����ظõ������ӵı��볤��
        for (String word : words) {
            len += trie.insert(word);
        }
        return len;
    }

    // ����tire
    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            // ���Ų��뵥��
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    isNew = true; // ���µ���
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            // ������µ��ʵĻ����볤�������µ��ʵĳ���+1�����򲻱䡣
            return isNew ? word.length() + 1 : 0;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }

}
