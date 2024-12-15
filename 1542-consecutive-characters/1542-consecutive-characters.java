class Solution {
    public int maxPower(String s) {
        int curr = 1, max = 1; // Start with 1 since a single character is a valid substring
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++; // Increment the current power if characters match
            } else {
                curr = 1; // Reset current power if characters differ
            }
            max = Math.max(max, curr); // Update the maximum power
        }
        return max;
    }
}
