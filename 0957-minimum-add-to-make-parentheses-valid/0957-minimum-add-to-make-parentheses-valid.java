class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); 
                } else {
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}