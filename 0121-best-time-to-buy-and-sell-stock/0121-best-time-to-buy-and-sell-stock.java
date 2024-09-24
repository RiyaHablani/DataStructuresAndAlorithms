class Solution {
    public int maxProfit(int[] arr) {
        int maxProfit=0,profit=0,minPrice=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<minPrice){
                minPrice=arr[i];
            }else{
                profit=arr[i]-minPrice;
                maxProfit=Math.max(profit,maxProfit);
            }
        }
        return maxProfit;
    }
}