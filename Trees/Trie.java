package Trees;

public class Trie {

    Node root;

    private class Node {

        char value;
        Node[] childrens = new Node[26];
        boolean isEndOfWord;

        public Node() {
        }

        public Node(char value) {
            this.value = value;
        }

    }

    public void insert(String word) {

        if (root == null) {
            root = new Node();
        }

        Node current = root;

        for (char ch : word.toCharArray()) {
            if (current.childrens[ch - 'a'] == null) {
                current.childrens[ch - 'a'] = new Node(ch);
            }
            current = current.childrens[ch - 'a'];
        }
    }
}
