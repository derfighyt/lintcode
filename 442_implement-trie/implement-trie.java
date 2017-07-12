/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    char val;
    Map<Character, TrieNode> next;
    public TrieNode() {
        isWord = false;
        next = new HashMap();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
        }
        return true;
    }
}
