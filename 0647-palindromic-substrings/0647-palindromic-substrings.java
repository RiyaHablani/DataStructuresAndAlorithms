class Solution {
    public int countSubstrings(String s) {
        int c = 0;
        // Loop through each starting index of the substring
        for (int i = 0; i < s.length(); i++) {
            // Loop through each ending index of the substring
            for (int j = i; j < s.length(); j++) {
                // Extract the substring from index i to j+1
                String str = s.substring(i, j + 1);
                // Check if the extracted substring is a palindrome
                if (ispalindrome(str)) {
                    // If it is, increment the count
                    c++;
                }
            }
        }
        // Return the total count of palindromic substrings
        return c;
    }

    // Helper function to check if a given string is a palindrome
    public boolean ispalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        // Check characters from both ends towards the center
        while (i < j) {
            // If characters at positions i and j are different, it's not a palindrome
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        // If all characters match, it's a palindrome
        return true;
    }
}