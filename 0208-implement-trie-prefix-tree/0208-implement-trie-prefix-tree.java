class TrieNode {
    TrieNode[] trieNode = new TrieNode[26];
    boolean wordEnd;

    boolean contains(char ch) {
        return trieNode[ch - 'a'] != null;
    }
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch))
                node.trieNode[ch - 'a'] = new TrieNode();
            node = node.trieNode[ch - 'a'];
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode node = root;
        for (char ch : s.toCharArray()) {
            if (!node.contains(ch)) return null;
            node = node.trieNode[ch - 'a'];
        }
        return node;
    }
}