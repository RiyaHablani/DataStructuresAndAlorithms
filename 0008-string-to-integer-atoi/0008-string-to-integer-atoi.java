class Solution {
    public int myAtoi(String s) {
        long result = 0; 
        int sign = 1; 
        int i = 0;

       
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

      
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = result * 10 + (ch - '0');
             
                if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break; 
            }
            i++;
        }

        return (int) result * sign; 
    }
}
