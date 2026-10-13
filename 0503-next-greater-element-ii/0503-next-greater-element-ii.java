class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int arr[]=new int[nums.length];
        int n=nums.length;
        for(int i=n*2-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    arr[i]=-1;
                }else{
                    arr[i]=stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return arr;
    }
}