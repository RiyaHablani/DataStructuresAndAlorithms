class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")
            || tokens[i].equals("*") || tokens[i].equals("/")){
                int nums1=stack.pop();
                int nums2=stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(nums1+nums2);
                }else if(tokens[i].equals("-")){
                    stack.push(nums2-nums1);
                }else if(tokens[i].equals("*")){
                    stack.push(nums2*nums1);
                }else if(tokens[i].equals("/")){
                    stack.push(nums2/nums1);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}