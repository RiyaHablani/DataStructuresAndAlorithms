class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack= new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;
    }
}