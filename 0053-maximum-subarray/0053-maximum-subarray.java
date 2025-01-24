class Solution {
    public int maxSubArray(int[] arr) {
        int currSum=0,maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];//
            if(arr[i]>currSum){
                currSum=0;
                currSum+=arr[i];
            }
            if(currSum>maxSum){
                maxSum=Math.max(maxSum,currSum);
            }
        }
         return maxSum;
    }
}