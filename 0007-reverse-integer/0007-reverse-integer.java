class Solution {
    public int reverse(int x) {
        double r,s=0;
        while(x!=0){
            r=x%10;
            s=s*10+r;
            if(s>=Integer.MAX_VALUE || s<=Integer.MIN_VALUE ) 
                return 0;
            x=x/10;
        }
        return (int)s;
        
    }
}