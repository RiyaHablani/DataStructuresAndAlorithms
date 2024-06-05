class Solution {
    public List<String> commonChars(String[] words) {
        // Initialize a list to store the common characters
        List<String> list = new ArrayList<>();

        // Initialize an array to store the frequency of characters in the first word
        int[] minFreq = new int[26];

        // Iterate through each character in the first word and update its frequency
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++; // Increment the count of the character
        }

        // Compare the frequency of characters in the remaining words with the first word
        for (int i = 1; i < words.length; i++) {
            // Initialize an array to store the frequency of characters in the current word
            int[] charCount = new int[26];

            // Iterate through each character in the current word and update its frequency
            for (char c : words[i].toCharArray()) {
                charCount[c - 'a']++; // Increment the count of the character
            }

            // Update the minimum frequency of characters seen so far
            for (int j = 0; j < 26; j++) {
                if (charCount[j] < minFreq[j]) {
                    minFreq[j] = charCount[j]; // Update the minimum frequency
                }
            }
        }

        // Add the common characters to the list based on the minimum frequency
        for (int i = 0; i < 26; i++) {
            // Add each character to the list as many times as its minimum frequency
            while (minFreq[i] > 0) {
                list.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--; // Decrement the frequency count
            }
        }

        // Return the list of common characters
        return list;
    }
}