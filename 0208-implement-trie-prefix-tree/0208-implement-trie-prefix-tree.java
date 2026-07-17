class Trie {
    
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(current.children[idx]==null){
                current.children[idx]=new TrieNode();
            }
            current=current.children[idx];
        }
        current.isEnd=true;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            int idx=c-'a';
            if(curr.children[idx]==null)return false;
            curr=curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */