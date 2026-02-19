package Trie;

class WordDictionary {
    private static class Children{
        Children[] children = new Children[26];
        boolean eow = false; // represents End of Word
    }

    private final Children root;
    public WordDictionary() {
        this.root = new Children();
    }

    public void addWord(String word) {
        Children curr = root;
        for (char ch : word.toCharArray()){
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new Children();
            }
            curr = curr.children[index];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int index, Children node) {
        if (node == null) return false;

        // if we reached end of the word
        if (index == word.length()) {
            return node.eow;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // try all possible children
            for (Children child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = ch - 'a';
            return dfs(word, index + 1, node.children[idx]);
        }
    }
}

