class Solution {
    public int arrangeCoins(int n) {
        long start=1;
        long end=n;//5
        long ans=0;
        long mid=0;

        while(start<=end){
            mid=start+(end-start)/2;//3,1,2
            long coinCount=(mid*(mid+1))/2;//6,1,3

            if(coinCount<=n){
                ans=mid;//1,2
                start=mid+1;//2,3
            }else{
                end=mid-1;//2
            }
        }
        return (int)ans;
    }
}