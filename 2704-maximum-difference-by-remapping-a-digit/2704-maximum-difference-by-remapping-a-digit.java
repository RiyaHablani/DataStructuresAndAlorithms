class Solution {
    public int minMaxDifference(int num) {
        // Convert the number to string for easy digit manipulation
        String numStr = Integer.toString(num);
        // Find maximum by replacing the first non-9 digit with 9
        char maxReplaceDigit = ' ';
        for (char c : numStr.toCharArray()) {
            // Find the first digit that is not '9'
            if (c != '9') {
                maxReplaceDigit = c;
                break;
            }
        }
        String maxNumStr;
        if (maxReplaceDigit == ' ') {
            // All digits are '9', so no replacement needed
            maxNumStr = numStr;
        } else {
            // Replace all occurrences of the first non-9 digit with '9'
            maxNumStr = numStr.replace(maxReplaceDigit, '9');
        }
        int maxNum = Integer.parseInt(maxNumStr);
        // Find minimum by replacing the first digit that is not '0' with '0'
        char minReplaceDigit = numStr.charAt(0);
        String minNumStr = numStr.replace(minReplaceDigit, '0');
        int minNum = Integer.parseInt(minNumStr);
        // Return the difference between maximum and minimum
        return maxNum - minNum;
    }
}
