class Solution {
    public int longestPalindrome(String s) {
        // Initialize an array to store the frequency of characters.
        int[] freq = new int[128];
        int sum = 0;

        // Loop through the characters of the input string.
        for (int i = 0; i < s.length(); i++) {
            // Increment the frequency of the character at index 'i' in the array.
            freq[s.charAt(i)]++;
        }

        // Iterate through the array to calculate the length of the longest palindrome.
        for (int i = 0; i < 128; i++) {
            int value = freq[i];

            // If the frequency of the character is even, add it directly to the sum.
            if (value % 2 == 0) {
                sum += value;
            } else {
                // If the frequency is odd, add (value - 1) to the sum.
                sum += value - 1;
            }
        }
        // Add 1 to the sum if there's at least one character with an odd frequency.
        if (sum < s.length()) {
            sum++;
        }
        // Return the length of the longest palindrome.
        return sum;
    }
}