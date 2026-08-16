class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        String str = sb.toString();
        if (str.contains(b)) {
            return count;
        }
        str += a;
        count++;
        return str.contains(b) ? count : -1;
    }
}