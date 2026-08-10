class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort children by greed
        Arrays.sort(g);
        // Sort cookies by size
        Arrays.sort(s);
        int i = 0; // Child pointer
        int j = 0; // Cookie pointer
        int count = 0;
        while (i < g.length && j < s.length) {
            // Current cookie can satisfy current child
            if (s[j] >= g[i]) {
                count++;
                i++; // Move to next child
            }
            // Always move to the next cookie
            j++;
        }
        return count;
    }
}