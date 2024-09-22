class Solution {
    public boolean isPalindrome(int n) {
        int original = n;
        int temp = 0;
        n = Math.abs(n);  // Convert the number to positive
        
        // Reverse the number
        while (n > 0) {
            int digit = n % 10;
            temp = temp * 10 + digit;
            n = n / 10;
        }
        
        if (original < 0) {
            String reversedWithMinus = temp + "-";
            System.out.println(reversedWithMinus);  
        }
        if (original == temp) {
            return true;
        } else {
            return false;
        }
    }
}
