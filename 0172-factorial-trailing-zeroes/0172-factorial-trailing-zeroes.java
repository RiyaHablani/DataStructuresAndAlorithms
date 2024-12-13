class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        // Count the number of multiples of 5, 25, 125, etc.
        while (n >= 5) {
            n /= 5;       // Divide n by 5
            count += n;   // Add the quotient to count
        }
        
        return count;  // Return the total count of trailing zeros
    }
}
