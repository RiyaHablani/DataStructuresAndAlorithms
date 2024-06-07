class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        int n = text.length();
        
        // Count frequency of each character
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }
        
        int maxLen = 0;
        for (int i = 0; i < n;) {
            // Find the length of the current block of the same character
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int currentBlockLength = j - i;

            // Check the length of the next block after a different character
            int nextBlockStart = j + 1;
            while (nextBlockStart < n && text.charAt(nextBlockStart) == text.charAt(i)) {
                nextBlockStart++;
            }
            int nextBlockLength = nextBlockStart - j - 1;

            // Determine the maximum length considering a possible swap
            int totalLength = currentBlockLength + nextBlockLength;
            if (totalLength < freq[text.charAt(i) - 'a']) {
                totalLength++;
            }
            maxLen = Math.max(maxLen, totalLength);

            // Move to the next block of characters
            i = j;
        }
        
        return maxLen;
    }
}