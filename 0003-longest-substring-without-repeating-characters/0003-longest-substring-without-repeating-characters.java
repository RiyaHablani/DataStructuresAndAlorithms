class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int l = 0, r = 0, ans = 0;
        
        while (r < len) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}