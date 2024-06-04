class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0"; // Handle case where all digits are removed

        StringBuilder sb = new StringBuilder(num);
        int i = 0;
        while (k > 0 && i < sb.length() - 1) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                k--;
                if (i != 0) i--; // Move back one step to check the previous digit
            } else {
                i++;
            }
        }

        // Remove trailing zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Handle case where k > 0 but all possible removals have been done
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}