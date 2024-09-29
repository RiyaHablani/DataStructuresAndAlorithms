class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int largestCount = 0, l = 0, maxlen = 0;
        for (int r = 0; r < s.length(); r++) {
            arr[s.charAt(r) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(r) - 'A']);
            if (r - l + 1 - largestCount > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
}