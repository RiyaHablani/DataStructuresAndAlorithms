class Solution {
    class Trie {
        Map<String, Trie> children = new HashMap<>();
        String key = "";
        boolean deleted = false;
    }
    Map<String, List<Trie>> seen = new HashMap<>();
    Trie root = new Trie();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Build the trie from all paths
        for (List<String> path : paths) {
            Trie node = root;
            for (String folder : path) {
                node.children.putIfAbsent(folder, new Trie());
                node = node.children.get(folder);
                node.key = folder;
            }
        }
        // Mark duplicates by serialization
        serialize(root);
        // Collect all valid paths
        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    // Serialize subtree, track duplicates
    String serialize(Trie node) {
        if (node.children.isEmpty()) return "";
        List<String> serials = new ArrayList<>();
        for (Trie child : node.children.values())
            serials.add(child.key + "(" + serialize(child) + ")");
        Collections.sort(serials);
        String serial = String.join("", serials);
        seen.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        if (seen.get(serial).size() > 1) {
            for (Trie t : seen.get(serial)) t.deleted = true;
        }
        return serial;
    }

    // Collect non-deleted paths
    void collect(Trie node, List<String> path, List<List<String>> result) {
        for (Trie child : node.children.values()) {
            if (child.deleted) continue;
            path.add(child.key);
            result.add(new ArrayList<>(path));
            collect(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
