class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int n=arr.length;
        int res[]=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    res[i]=-1;
                }else{
                    res[i]=stack.peek();
                }
            }
            stack.push(arr[i%n]);
        }
        return res;
    }
}