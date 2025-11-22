class Solution {
    public int mySqrt(int x) {
        int start=1;
        int end=x;
        while(start<=end){
            int mid=start+(end-start)/2;//4,2,2,3
            if(mid<=x/mid){
                if(x%mid==0 && mid==x/mid){
                    return mid;
                }
                start=mid+1;//2,3
            }else{
                end=mid-1;//3,2
            }
        }
        return end;
    }
}
// .....start->  <-end
//....end    start