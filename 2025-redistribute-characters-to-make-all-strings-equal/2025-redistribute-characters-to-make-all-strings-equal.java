class Solution {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26]; // Frequency array for 'a' to 'z'

        // Count the occurrences of each character
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                freq[c - 'a']++; // Map 'a' to index 0, 'b' to index 1, and so on
            }
        }

        int n = words.length;

        // Check if each character's count is a multiple of the number of strings
        for (int i = 0; i < 26; i++) {
            if (freq[i] % n != 0) {
                return false;
            }
        }

        return true;
    }
}
