class Solution {
    // public int minCostClimbingStairs(int[] cost) {
    //     Recursion
    //     int n=cost.length;
    //     return recur(n,cost);
    // }
    // public int recur(int n,int cost[]){
    //     //base case
    //     if(n==0 || n==1){
    //         return 0;
    //     }
    //     int oneStep=cost[n-1]+recur(n-1,cost);
    //     int twoStep=cost[n-2]+recur(n-2,cost);

    //     return Math.min(oneStep,twoStep);
    // }
  
  
    //  public int minCostClimbingStairs(int[] cost) {
    //    // Memorization TC:O(n)
    //    int n=cost.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return recur(n,cost,dp);
    // }
    // public int recur(int n,int cost[],int dp[]){
    //     if(n==0 || n==1){
    //         dp[n]=0;
    //         return 0;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int oneStep=cost[n-1]+recur(n-1,cost,dp);
    //     int twoStep=cost[n-2]+recur(n-2,cost,dp);

    //     dp[n] = Math.min(oneStep, twoStep);
    //     return dp[n];
    // }


      public int minCostClimbingStairs(int[] cost) {
       // Tabulation TC:O(n)
       int n=cost.length;
       int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            int oneStep=cost[i-1]+dp[i-1];
            int twoStep=cost[i-2]+dp[i-2];

            dp[i]=Math.min(oneStep,twoStep);
        }
        return dp[n];
    }
}