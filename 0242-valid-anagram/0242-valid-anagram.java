class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            map.put(charS, map.getOrDefault(charS, 0) + 1);
            char charT = t.charAt(i);
            map.put(charT, map.getOrDefault(charT, 0) - 1);
        }
        for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
