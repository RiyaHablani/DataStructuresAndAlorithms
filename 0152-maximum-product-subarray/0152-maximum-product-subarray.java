class Solution {
    public int maxProduct(int[] arr) {
        int result = arr[0]; 
        for (int i = 0; i < arr.length; i++) {
            int p = 1; 
            for (int j = i; j < arr.length; j++) {
                p *= arr[j]; 
                result = Math.max(result, p); 
            }
        }
        return result;
    }
}