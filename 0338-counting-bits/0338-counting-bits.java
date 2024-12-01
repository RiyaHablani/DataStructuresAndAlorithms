class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];  // Array to store the result for numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            // Count the number of 1's in the binary representation of i
            arr[i] = countOnes(i);
        }
        return arr;
    }
    
    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;  // Add 1 if the last bit is 1
            num >>= 1;          // Shift right by 1 to process the next bit
        }
        return count;
    }
}
