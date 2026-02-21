class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i; // initially each node's parent is itself (unknown)

        int[] cand1 = null, cand2 = null; // two edges pointing to the same child (if any)

        // Step 1: detect a node with two parents
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[v] != v) {           // v already has a parent -> two-parent conflict
                cand1 = new int[] { parent[v], v }; // first edge to v (already recorded)
                cand2 = new int[] { u, v };         // second edge to v (current)
                // Temporarily remove cand2 from consideration by marking it invalid
                e[1] = 0; // mark this edge as skipped in the UF pass
            } else {
                parent[v] = u;
            }
        }

        // Step 2: Union-Find to detect cycle (skipping cand2 if existed)
        DSU dsu = new DSU(n + 1);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (v == 0) continue; // skip the second edge in the two-parent conflict
            if (!dsu.union(u, v)) { // cycle found
                // If there was no two-parent conflict, this edge is the answer.
                // If there was a two-parent conflict, the first edge to that child is the culprit.
                return cand1 == null ? new int[] { u, v } : cand1;
            }
        }

        // If no cycle after skipping cand2, then cand2 is the redundant edge.
        return cand2;
    }

    // Disjoint Set Union with path compression and union by rank
    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false; // union would create a cycle
            if (r[ra] < r[rb]) p[ra] = rb;
            else if (r[ra] > r[rb]) p[rb] = ra;
            else { p[rb] = ra; r[ra]++; }
            return true;
        }
    }
}