class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            // Remove characters until duplicate is removed
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            // Add current character
            set.add(s.charAt(right));
            // Calculate current window length
            int len = right - left + 1;
            // Update maximum length
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}