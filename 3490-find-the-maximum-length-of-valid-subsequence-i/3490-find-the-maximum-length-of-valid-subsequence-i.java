class Solution {
    public int maximumLength(int[] nums) {
        // Count how many even and odd numbers are in the array
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num % 2 == 0) 
                cnt1++;  // count of even numbers
            else 
                cnt2++;  // count of odd numbers
        }

        // Try to find longest subsequence with alternating even-odd pattern
        int eve = 0, odd = 0;

        for (int num : nums) {
            if (num % 2 == 0)
                eve = Math.max(eve, odd + 1); // add even after odd
            else
                odd = Math.max(odd, eve + 1); // add odd after even
        }

        // Return the maximum of:
        // - all even (cnt1)
        // - all odd (cnt2)
        // - longest alternating starting with odd then even (eve)
        // - longest alternating starting with even then odd (odd)
        return Math.max(Math.max(cnt1, cnt2), Math.max(eve, odd));
    }
}
