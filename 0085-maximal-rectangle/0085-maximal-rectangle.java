class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int heights[]=new int[matrix[0].length];
        int largest=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int val=matrix[i][j]-'0';
                if(val==0){
                    heights[j]=0;
                }else{
                    heights[j]+=(val);
                }
            }
            int maxArea=largestRectangleArea(heights);
            if(largest<maxArea){
                largest=maxArea;
            }
        }
        return largest;
    }
    public int largestRectangleArea(int[] heights) {
        int ns[] = findNextSmaller(heights);
        int ps[] = findPrevSmaller(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int h = heights[i];
            int w = ns[i] - ps[i] - 1;
            max = Math.max(max, (h*w));
        }
        return max;
    }
	public static int[] findPrevSmaller(int arr[]) 
	{ 
	    // Your code goes here
			int n = arr.length;
	    Stack<Integer> stack = new Stack<>();
	    int res[] = new int[n];
	    for(int i=0;i<n;i++){
	        while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]) {
	            stack.pop();
	        }
	        
	        if(stack.isEmpty()) {
	            res[i] = -1;
	        } else {
	            res[i] = stack.peek();
	        }
	        
	        stack.push(i);
	    }
	    return res;
	} 

    public static int[] findNextSmaller(int arr[]) 
	{ 
	    // Your code goes here
			int n = arr.length;
	    Stack<Integer> stack = new Stack<>();
	    int res[] = new int[n];
	    for(int i=n-1;i>=0;i--){
	        while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]) {
	            stack.pop();
	        }
	        
	        if(stack.isEmpty()) {
	            res[i] = n;
	        } else {
	            res[i] = stack.peek();
	        }
	        
	        stack.push(i);
	    }
	    return res;
	}
}