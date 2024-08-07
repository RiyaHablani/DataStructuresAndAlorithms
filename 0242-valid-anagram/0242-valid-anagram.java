class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // Count frequency of each character in s
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
            
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        // Compare frequency maps
        for (char key : sMap.keySet()) {
            if (!sMap.get(key).equals(tMap.getOrDefault(key, 0))) {
                return false;
            }
        }

        return true;
    }
}