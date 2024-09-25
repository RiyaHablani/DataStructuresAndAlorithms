class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two must be positive and have only one bit set
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}