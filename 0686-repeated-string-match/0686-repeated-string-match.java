class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatedA = new StringBuilder(a);
        int count = 1;

        // Repeat string `a` until its length exceeds or matches the length of `b`
        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            count++;
        }

        // Check if `b` is now a substring of the repeated `a`
        if (repeatedA.indexOf(b) != -1) {
            return count;
        }

        // Check one more repetition of `a`
        repeatedA.append(a);
        count++;
        if (repeatedA.indexOf(b) != -1) {
            return count;
        }

        // If `b` is still not a substring, return -1
        return -1;
    }
}