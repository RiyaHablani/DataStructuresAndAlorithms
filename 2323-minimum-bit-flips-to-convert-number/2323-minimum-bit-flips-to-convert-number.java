class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        // Count the number of set bits in 'num' (which indicates the flips needed)
        int count = 0;
        while (num > 0) {
            // Increment the count if LSB is 1
            count += num & 1;
            // Remove the least significant bit (LSB)
            num >>= 1;
        }
        
        return count;
    }
}