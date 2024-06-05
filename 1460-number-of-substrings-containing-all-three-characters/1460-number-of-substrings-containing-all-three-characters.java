class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // count[0] for 'a', count[1] for 'b', count[2] for 'c'
        int left = 0, right = 0, result = 0;
        int n = s.length();

        while (right < n) {
            // Increment the count of the character at the right pointer
            count[s.charAt(right) - 'a']++;

            // Check if the current window contains at least one of each 'a', 'b', and 'c'
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // If valid, add the number of substrings that end at the current right pointer
                result += n - right;

                // Move the left pointer to reduce the window size and try to find other valid windows
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        return result;
    }
}