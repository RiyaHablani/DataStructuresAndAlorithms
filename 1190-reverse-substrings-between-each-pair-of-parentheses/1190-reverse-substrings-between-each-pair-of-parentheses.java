class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=')'){
                stack.push(ch);
            }else{
                StringBuilder sb=new StringBuilder();
                while(!stack.isEmpty() && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
                for(int j = 0; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
        }
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}