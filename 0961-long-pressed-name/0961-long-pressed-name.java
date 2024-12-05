class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        
        // Traverse both strings
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++; // Characters match, move both pointers
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false; // Invalid extra character in typed
            }
            j++; // Always move pointer for typed
        }
        
        // Ensure all characters in name are matched
        return i == name.length();
    }
}
