class Solution {
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     return rec(nums,n-1);
    // }
    // public int rec(int nums[],int index){
    //     //base case
    //     //TC:O(n),SC:O(n)
    //     if(index==0){
    //         return nums[0];
    //     }if(index==-1){
    //         return 0;
    //     }
    //     //pick and no pick logic
    //     int pick=nums[index]+rec(nums,index-2);
    //     int nonpick=0+rec(nums,index-1);
    //     return Math.max(pick,nonpick);
    // }


//     public int rob(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return rec(nums,n,dp);
//     }
//     public int rec(int nums[],int index,int dp[]){
//         //base case
//         //TC:O(n),SC:O(n)
//         //shifting logic->index->+1,dp->as it is,nums->-1
//         // shifting logic -> index is 1-based (dp[index] = max profit for first 'index' houses)
// // so we access nums[index-1] when using house values

//         if(index==1){
//             dp[index]=nums[0];
//             return nums[0];
//         }if(index==0){
//             dp[index]=0;
//             return 0;
//         }
//         if(dp[index]!=-1){
//             return dp[index];
//         }
//         //pick and no pick logic
//         int pick=nums[index-1]+rec(nums,index-2,dp);
//         int nonpick=0+rec(nums,index-1,dp);
//         dp[index]=Math.max(pick,nonpick);
//         return dp[index];
//     }



    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int index=2;index<=n;index++){
            int pick=nums[index-1]+dp[index-2];
            int nonpick=0+dp[index-1];
            dp[index]=Math.max(pick,nonpick);
        }
        return dp[n];
    }
}