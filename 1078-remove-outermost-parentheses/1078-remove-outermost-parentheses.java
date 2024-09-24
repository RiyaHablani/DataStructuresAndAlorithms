class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack= new Stack<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(!stack.isEmpty()){
                   sb.append(ch);
                }
                stack.push(ch);
            }else{
                stack.pop();
                if(!stack.isEmpty()){
                   sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}