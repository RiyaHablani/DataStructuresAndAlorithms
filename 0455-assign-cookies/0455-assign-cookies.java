class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        int cookie = 0;
        
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                // The current cookie can satisfy the current child's greed factor
                child++;
            }
            // Move to the next cookie
            cookie++;
        }
        
        return child;
    }
}