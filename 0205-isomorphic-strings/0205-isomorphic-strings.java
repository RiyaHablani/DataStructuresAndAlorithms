class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        // Use arrays of size 256 (ASCII character set size)
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            // If either of the mappings is inconsistent, return false
            if (map1[c1] != map2[c2]) {
                return false;
            }
            
            // Set both mappings to the current index + 1 (to avoid conflicts with default 0)
            map1[c1] = i + 1;
            map2[c2] = i + 1;
        }
        
        return true;
    }
}
