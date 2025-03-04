class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;  // a is already included once

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.toString().contains(b)) return count;

        sb.append(a);
        count++;

        return sb.toString().contains(b) ? count : -1;
    }
}