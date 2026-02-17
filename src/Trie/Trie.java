package Trie;

public class Trie {
    private static class Child {
        Child [] children = new Child[26];
        boolean end = false;
    }

    private final Child root;

    public Trie() {
        this.root = new Child();
    }

    public void insert(String word) {
        Child curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new Child();
            }
            curr = curr.children[index];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        Child node = traverse(word);
        return node !=null && node.end;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private Child traverse(String word) {
        Child node = root;
        for (char ch: word.toCharArray()) {
            int index = ch - 'a';
            if(node.children[index] == null) return null;
            node = node.children[index];
        }
        return node;
    }
}
