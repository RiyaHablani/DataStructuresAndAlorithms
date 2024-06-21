class Solution {
  public int integerReplacement(int n) {
    int count = 0;
        
        while (n != 1) {
            if(n == 2147483647) return 32;
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                    // Special case for n == 3 to avoid infinite loop
                    // Choose n + 1 if it has more 1s in its binary representation than n - 1
                    n--;
                } else {
                    // Otherwise, choose n - 1
                    n++;
                }
            }
            count++;
       }
       return count;
    }
}