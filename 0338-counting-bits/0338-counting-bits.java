class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];  // Array to store the result for numbers from 0 to n
        for (int i = 1; i <= n; i++) {
            // Dynamic programming relation: count[i] = count[i >> 1] + (i & 1)
            arr[i] = arr[i >> 1] + (i & 1);
        }
        return arr;
    }
}
