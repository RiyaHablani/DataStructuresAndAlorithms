public class Solution {
    public boolean isMatch(String s, String p) {
        // If pattern is empty, string must also be empty
        if (p.isEmpty()) return s.isEmpty();

        // Check if first characters match (considering '.')
        boolean firstMatch = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // If next character in pattern is '*'
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // Either skip '*' and its previous char, or use it if firstMatch is true
            return isMatch(s, p.substring(2)) || 
                   (firstMatch && isMatch(s.substring(1), p));
        } else {
            // If no '*', move to next char in both string and pattern
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
