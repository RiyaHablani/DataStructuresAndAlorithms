class Solution {
    public int maxProduct(int[] arr) {
        if (arr.length == 0) return 0; 

        int maxPro = Integer.MIN_VALUE; 
        for (int i = 0; i < arr.length; i++) {
            int pro = 1; 
            for (int j = i; j < arr.length; j++) {
                pro *= arr[j]; 
                maxPro = Math.max(maxPro, pro); 
            }
        }
        return maxPro;
    }
}
