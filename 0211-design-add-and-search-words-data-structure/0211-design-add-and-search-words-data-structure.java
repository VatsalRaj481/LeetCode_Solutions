class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {

        // Reached end of search word
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        // Wildcard
        if (c == '.') {

            for (int i = 0; i < 26; i++) {

                if (node.children[i] != null) {

                    if (search(word, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }

            return false;
        }

        // Normal character
        int childIndex = c - 'a';

        if (node.children[childIndex] == null) {
            return false;
        }

        return search(
            word,
            index + 1,
            node.children[childIndex]
        );
    }
}