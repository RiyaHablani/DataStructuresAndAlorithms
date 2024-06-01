class Solution {
    public int maximumValue(String[] strs) {
        int result = 0;

for (final String str : strs) {
    boolean isNumeric = true;

    // Check if the string is numeric
    for (int i = 0; i < str.length(); ++i) {
        if (!Character.isDigit(str.charAt(i))) {
            isNumeric = false;
            break;
        }
    }

    // If the string is numeric, parse it to an integer and compare with result
    // If not, compare the length of the string with result
    if (isNumeric) {
        result = Math.max(result, Integer.parseInt(str));
    } else {
        result = Math.max(result, str.length());
    }
}

return result;
    }
}