class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, l = 0; // 'l' is the left pointer of the current window

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // Move the left pointer to the right of the last occurrence of ch
                l = Math.max(l, map.get(ch) + 1);
            }
            // Update the position of the current character
            map.put(ch, i);
            // Update the answer with the maximum length of the current window
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}
