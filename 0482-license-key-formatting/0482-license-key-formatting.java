class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) { // Start from the last index
            char c = s.charAt(i);
            if (c != '-') { // Ignore dashes
                if (j == k) { // Add a dash after every group of k characters
                    sb.append('-');
                    j = 0;
                }
                sb.append(Character.toUpperCase(c)); // Convert to uppercase and add to result
                j++;
            }
        }
        
        return sb.reverse().toString(); // Reverse the StringBuilder and return
    }
}