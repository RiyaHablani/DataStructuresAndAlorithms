class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int pos = -n;

        // Left to right pass to find the shortest distance to previous occurrences of c
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            result[i] = i - pos;
        }

        // Right to left pass to find the shortest distance to next occurrences of c
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - pos));
        }

        return result;
    }
}