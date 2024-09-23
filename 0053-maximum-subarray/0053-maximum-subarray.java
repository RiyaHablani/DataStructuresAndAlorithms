class Solution {
    public int maxSubArray(int[] arr) {
        int sum=0,i=0,ans=Integer.MIN_VALUE;
        while(i<arr.length){
            sum=sum+arr[i];
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
            i++;
        }
        return ans;
    }
}