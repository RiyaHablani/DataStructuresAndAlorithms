class Solution {
    class Trie {
        Map<String, Trie> children = new HashMap<>();
        String key = "";
        boolean deleted = false;
    }
    Map<String, List<Trie>> seen = new HashMap<>();
    Trie root = new Trie();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Build Trie
        for (List<String> path : paths) {
            Trie cur = root;
            for (String f : path) {
                cur.children.putIfAbsent(f, new Trie());
                cur = cur.children.get(f);
                cur.key = f;
            }
        }
        // Mark duplicates
        serialize(root);
        // Collect
        List<List<String>> res = new ArrayList<>();
        dfs(root, new ArrayList<>(), res);
        return res;
    }

    String serialize(Trie node) {
        if (node.children.isEmpty()) return "";
        List<String> list = new ArrayList<>();
        for (var e : node.children.entrySet())
            list.add(e.getKey() + "(" + serialize(e.getValue()) + ")");
        Collections.sort(list);
        String serial = String.join("", list);
        seen.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        if (seen.get(serial).size() > 1)
            for (Trie t : seen.get(serial)) t.deleted = true;
        return serial;
    }

    void dfs(Trie node, List<String> path, List<List<String>> res) {
        for (var e : node.children.entrySet()) {
            Trie child = e.getValue();
            if (child.deleted) continue;
            path.add(child.key);
            res.add(new ArrayList<>(path));
            dfs(child, path, res);
            path.remove(path.size() - 1);
        }
    }
}
