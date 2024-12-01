class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0; // Edge case: anything to the power of 0 is 1.
        
        long N = n; // Handle edge case where n = Integer.MIN_VALUE
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) result *= x;  // If the current bit is 1, multiply result by x
            x *= x;  // Square the base
            N >>= 1; // Right shift n
        }

        return result;
    }
}