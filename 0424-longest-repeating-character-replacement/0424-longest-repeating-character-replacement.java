class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Array to store the frequency of each character in the current window
        int maxLength = 0; // The length of the longest substring
        int maxCount = 0; // The frequency of the most frequent character in the current window
        int start = 0; // Start index of the sliding window

        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++; // Increment the count of the current character
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']); // Update maxCount with the most frequent character count

            // If the current window size minus the maxCount is greater than k,
            // it means we need more than k replacements to make all characters in the window the same.
            // So, shrink the window from the start.
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--; // Decrement the count of the character going out of the window
                start++; // Shrink the window
            }

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}