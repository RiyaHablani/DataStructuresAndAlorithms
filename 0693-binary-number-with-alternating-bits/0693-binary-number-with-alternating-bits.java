class Solution {
    public boolean hasAlternatingBits(int num) {
        // Perform XOR with the number right-shifted by 1 bit
        int res = num ^ (num >> 1);
        
        // If the result is a number with all bits set to 1, then the number had alternating bits
        // Check if the result is of the form 111... (i.e., a number that is one less than a power of 2)
        return (res & (res + 1)) == 0;
    }
}