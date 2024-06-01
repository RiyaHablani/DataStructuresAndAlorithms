class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int j = i;
            while(j < s.length()) {
                char ch = s.charAt(j);
                if(map.containsKey(ch) && map.get(ch) == 2) {
                    break;
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
                j++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}