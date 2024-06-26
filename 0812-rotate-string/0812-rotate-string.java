class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (j < goal.length() && s.charAt((i + j) % s.length()) == goal.charAt(j)) {
                j++;
            }
            if (j == goal.length()) {
                return true;
            }
        }
        
        return false;
    }
}