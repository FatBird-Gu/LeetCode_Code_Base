package mid;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // ���� true
        System.out.println(trie.search("app"));     // ���� false
        System.out.println(trie.startsWith("app")); // ���� true
        trie.insert("app");
        System.out.println(trie.search("app"));     // ���� true


    }
}

class TrieNode {
    public boolean isEnd = false;
    public TrieNode next[] = new TrieNode[26];
}

class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode head = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (head.next[chs[i] - 'a'] == null) {
                head.next[chs[i] - 'a'] = new TrieNode();
            }
            head = head.next[chs[i] - 'a'];
        }
        head.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode head = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (head.next[chs[i] - 'a'] == null) {
                return false;
            }
            head = head.next[chs[i] - 'a'];
        }
        return head.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode head = root;
        char[] chs = prefix.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (head.next[chs[i] - 'a'] == null) {
                return false;
            }
            head = head.next[chs[i] - 'a'];
        }
        return true;
    }
}