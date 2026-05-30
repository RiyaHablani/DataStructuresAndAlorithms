class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else if(ch==')'){
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(!stack.isEmpty() && i==stack.peek()){
                stack.pop();
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}