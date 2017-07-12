public class WordDictionary {

    class TreeNode {
        char val;
        Map<Character, TreeNode> children;
        public TreeNode(char val) {
            this.val = val;
            this.children = new HashMap();
        }
    }

    TreeNode root = new TreeNode('.');
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        if (word != null && word.length() > 0) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TreeNode(c));
                }
                node = node.children.get(c);
            }
            node.children.put('$', null);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        if (word != null && word.length() > 0) {
            return search(word, root);
        }
        return false;
    }

    private boolean search(String word, TreeNode root) {
        int length = word.length();
        if (root == null) {
            return false;
        }
        if (length == 0) {
            //已经是最后一个字符了
            if (root.children.containsKey('$')) {
                return true;
            } else {
                return false;
            }
        }
        char c = word.charAt(0);
        if (c != '.') {
            //非正则
            if (!root.children.containsKey(c)) {
                return false;
            } else {
                return search(word.substring(1), root.children.get(c));
            }
        } else {
            for (TreeNode node : root.children.values()) {
                if (search(word.substring(1), node)) {
                    return true;
                }
            }
            return false;
        }
    }
}



// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
