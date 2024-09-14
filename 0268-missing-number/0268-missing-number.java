class Solution {
    public int missingNumber(int[] a) {
        int xor1 = 0, xor2 = 0, N = a.length;

        // XOR of array elements
        for (int i = 0; i < N; i++) {
            xor2 ^= a[i]; // XOR of all elements in the array
            xor1 ^= i + 1; // XOR of numbers from 1 to N
        }

        // XOR of xor1 with 0 to N gives the missing number
        return xor1 ^ xor2;
    }
}