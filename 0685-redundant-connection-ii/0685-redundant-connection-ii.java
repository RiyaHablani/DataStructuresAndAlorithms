class Solution {
    static class DSU {
        int[] p, r;
        DSU(int n) { p = new int[n + 1]; r = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (r[ra] < r[rb]) p[ra] = rb;
            else if (r[ra] > r[rb]) p[rb] = ra;
            else { p[rb] = ra; r[ra]++; }
            return true;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null, cand2 = null;

        // Pass 1: find a node with two parents
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (parent[v] == 0) parent[v] = u;
            else {
                cand1 = new int[] { parent[v], v }; // first edge into v
                cand2 = new int[] { u, v };         // second edge into v
                e[1] = 0; // mark this edge as "skipped" for pass 2
            }
        }

        // Pass 2: union-find, skipping cand2 if it existed
        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (v == 0) continue; // skip cand2
            if (!dsu.union(u, v)) { // cycle found
                // If no two-parent conflict, this edge closes the cycle
                if (cand1 == null) return e;
                // Else earlier edge is to blame together with the cycle
                return cand1;
            }
        }

        // If no cycle while skipping cand2, remove cand2
        return cand2;
    }
}