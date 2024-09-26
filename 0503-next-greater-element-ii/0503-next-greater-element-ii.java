class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack= new Stack<>();
        int arr[]= new int[nums.length];
        Arrays.fill(arr,-1);

        for(int i=0;i<2*nums.length;i++){
            int index=i%nums.length;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                arr[stack.pop()]=nums[index];
            }
            if (i < nums.length) {
                stack.push(index); 
            }
        }
        return arr;
    }
}