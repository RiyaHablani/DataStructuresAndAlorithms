class Solution {
    public String largestOddNumber(String num) {
        StringBuilder sb = new StringBuilder(num);
        while (sb.length() > 0 && (sb.charAt(sb.length() - 1) - '0') % 2 == 0) {
            sb.setLength(sb.length() - 1);  
        }
        return sb.toString();
    }
}