class Solution {
    public int repeatedStringMatch(String a, String b) {
        String repeatedA = a;
        int count = 1;

        while (repeatedA.length() < b.length()) {
            repeatedA += a;
            count++;
        }

        if (repeatedA.contains(b)) {
            return count;
        }

        repeatedA += a;
        count++;
        return repeatedA.contains(b) ? count : -1;
    }
}
