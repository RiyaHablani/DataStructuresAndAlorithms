class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Base case: if p is longer than s, no anagrams are possible
        if (s.length() < p.length()) return result;

        // Frequency arrays for 'a' to 'z'
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Populate the frequency array for p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        // Traverse the string s
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the sCount
            sCount[s.charAt(i) - 'a']++;

            // Remove the character that is sliding out of the window
            if (i >= windowSize) {
                sCount[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare the frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - windowSize + 1); // Starting index of the anagram
            }
        }

        return result;
    }
}