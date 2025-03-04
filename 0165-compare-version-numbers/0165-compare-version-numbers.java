class Solution {
    public int compareVersion(String version1, String version2) {
        // Split the version strings by "."
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        // Find the maximum length of the two version arrays
        int maxLength = Math.max(v1.length, v2.length);
        
        // Iterate through all revision indices
        for (int i = 0; i < maxLength; i++) {
            int num1, num2;

            // Check if index 'i' is within the bounds of v1
            if (i < v1.length) {
                num1 = Integer.parseInt(v1[i]); // Convert to integer
            } else {
                num1 = 0; // If out of bounds, assume 0
            }

            // Check if index 'i' is within the bounds of v2
            if (i < v2.length) {
                num2 = Integer.parseInt(v2[i]); // Convert to integer
            } else {
                num2 = 0; // If out of bounds, assume 0
            }

            // Compare the current revision numbers
            if (num1 > num2) {
                return 1; // version1 is greater
            } else if (num1 < num2) {
                return -1; // version2 is greater
            }
        }
        
        // Both versions are equal
        return 0;
    }
}
