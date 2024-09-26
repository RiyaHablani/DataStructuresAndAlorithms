class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else{
                if (stack.isEmpty()) {
                    return false; 
                }
                if((stack.peek()=='(' && ch==')') || (stack.peek()=='[' && ch==']')
                    || (stack.peek()=='{' && ch=='}')){
                    stack.pop();
                }else{
                    return false;
                }     
            }
        }
        return stack.isEmpty();
    }
}