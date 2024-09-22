class Solution {
    public int reverse(int n) {
        int original=n;
        int temp=0;
        n=Math.abs(n);
        while(n>0){
           int a=n%10;
           if (temp > (Integer.MAX_VALUE - a) / 10) {
                return 0;  
            }
           temp=temp*10+a;
           n=n/10;
        }
        if(original>0)
            return temp;
        else
            return -temp;
    } 
}