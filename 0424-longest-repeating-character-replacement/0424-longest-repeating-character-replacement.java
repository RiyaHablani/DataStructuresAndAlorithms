class Solution {

    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFrequency = Math.max(maxFrequency, map.get(ch));

            while ((right - left + 1) - maxFrequency > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}