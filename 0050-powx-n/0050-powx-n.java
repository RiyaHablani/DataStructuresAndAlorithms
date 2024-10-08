class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) {//n%2==1
                result *= x;
            }
            x *= x;
            N >>= 1;//n=n/2
        }
        return result;
    }
}