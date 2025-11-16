class Solution {
    public int findNthDigit(int n) {
        long digits = 1;      // digit length
        long count = 9;       // how many numbers with this digit length
        long start = 1;       // starting number for this digit length

        // Step 1: Move n into the correct digit group
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }
        // Step 2: Find the exact number containing the nth digit
        long number = start + (n - 1) / digits;
        // Step 3: Convert number to string and pick digit
        int index = (n - 1) % (int)digits;
        return String.valueOf(number).charAt(index) - '0';
    }
}
