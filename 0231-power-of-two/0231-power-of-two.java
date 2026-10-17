class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        //A power of 2 always has exactly one set bit.
        return (n&(n-1))==0;
    }
}