class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize stack with a base index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push the index of '('
            } else {
                stack.pop(); // Pop for a matching '('
                if (stack.isEmpty()) {
                    stack.push(i); // Push the index of unmatched ')'
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
