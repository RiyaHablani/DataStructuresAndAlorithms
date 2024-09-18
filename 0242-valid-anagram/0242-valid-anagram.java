class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            map1.put(charS, map1.getOrDefault(charS, 0) + 1);
            map2.put(charT, map2.getOrDefault(charT, 0) + 1);
        }
        return map1.equals(map2);
    }
}
