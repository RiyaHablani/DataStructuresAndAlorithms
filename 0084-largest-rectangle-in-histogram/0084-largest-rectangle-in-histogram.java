class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<=arr.length;i++){
            int ele=(i==n)?0:arr[i];
            while(!stack.isEmpty() && arr[stack.peek()]>ele){
                int h=arr[stack.pop()];
                int ps=(stack.isEmpty())?-1:stack.peek();
                int w=i-ps-1;
                maxArea=Math.max(maxArea,h*w);
            }
            stack.push(i);
        }
        return (maxArea==Integer.MIN_VALUE)?0:maxArea;
    }
}