class Solution {
    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();

        // Validate lengths
        if (start.length() != target.length()) return false;

        // Process both strings
        while (i < n && j < n) {
            // Skip '_' in both strings
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // Check if we've reached the end of both strings
            if (i == n && j == n) return true;

            // If one is at the end and the other is not
            if (i == n || j == n) return false;

            // Check if characters at i and j are different
            if (start.charAt(i) != target.charAt(j)) return false;

            // Check invalid movements for 'L'
            if (start.charAt(i) == 'L' && i < j) return false;

            // Check invalid movements for 'R'
            if (start.charAt(i) == 'R' && i > j) return false;

            // Move both pointers
            i++;
            j++;
        }

        // Ensure there are no leftover non-underscore characters
        while (i < n && start.charAt(i) == '_') i++;
        while (j < n && target.charAt(j) == '_') j++;

        return i == n && j == n;
    }
}