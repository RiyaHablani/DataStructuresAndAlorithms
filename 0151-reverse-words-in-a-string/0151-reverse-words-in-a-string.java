class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        // Push words to the stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (str.length() > 0) {  // Only push non-empty words
                    stack.push(str.toString());
                    str.setLength(0);  // Reset str for the next word
                }
            } else {
                str.append(ch);
            }
        }

        // Push the last word
        if (str.length() > 0) {
            stack.push(str.toString());
        }

        // Build the reversed words result
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
