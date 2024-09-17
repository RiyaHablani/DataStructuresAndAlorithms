class Solution {
    public int maxProfit(int[] Arr) {
       int mini=Arr[0],currProfit=0,maxProfit=0;

       for(int i=1;i<Arr.length;i++){
          currProfit=Arr[i]-mini;
          maxProfit=Math.max(maxProfit,currProfit);
          mini=Math.min(mini,Arr[i]);
       }
       return maxProfit;
    }
}