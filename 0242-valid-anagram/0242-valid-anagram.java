class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26]; 
        for (char charS : s.toCharArray()) {
            count[charS - 'a']++; 
        }
        for (char charT : t.toCharArray()) {
            count[charT - 'a']--; 
            if (count[charT - 'a'] < 0) {
                return false; 
            }
        }
        return true; 
    }
}
