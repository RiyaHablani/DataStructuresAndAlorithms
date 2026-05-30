class Solution {
    public String makeGood(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!stack.isEmpty() && Math.abs(ch-stack.peek())==32){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}