class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                int prev = stack.peek();
                if (Math.abs(prev) < Math.abs(asteroids[i])) {
                    stack.pop(); // prev destroyed
                } 
                else if (Math.abs(prev) == Math.abs(asteroids[i])) {
                    stack.pop(); // both destroyed
                    asteroids[i] = 0;
                    break;
                } 
                else {
                    asteroids[i] = 0; // current destroyed
                    break;
                }
            }
            if (asteroids[i] != 0) {
                stack.push(asteroids[i]);
            }
        }
        int[] arr = new int[stack.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return arr;
    }
}