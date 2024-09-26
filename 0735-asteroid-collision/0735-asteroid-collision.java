class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack= new Stack<>();
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(stack.isEmpty() || arr[i]>0){
                stack.push(arr[i]);
            }
            else{
                while (true) {
                    int prev = stack.peek();
                    if (prev < 0) {
                        stack.push(arr[i]);
                        break;
                    } else if (prev == -arr[i]) {
                        stack.pop();
                        break;
                    } else if (prev > -arr[i]) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(arr[i]);
                            break;
                        }
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
