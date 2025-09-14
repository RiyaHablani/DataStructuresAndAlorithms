class Solution {
    // public int climbStairs(int n) {
    //     TC: 2^n Recursion
    //     //base case
    //     if(n<=2){
    //         return n;
    //     }
    //     return climbStairs(n-1)+climbStairs(n-2);
    // }



    // public int climbStairs(int n) {
    //    //overlapping Subproblem
    //    //Memorization- top down apporach
    //    TC = O(n), SC = O(n)
    //    int dp[]=new int[n+1];
    //    Arrays.fill(dp,-1);
    //    return recur(n,dp);
    // }
    // public int recur(int n,int dp[]){
    //     if(n<=2){
    //         dp[n]=n;
    //         return n;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     dp[n]= recur(n-1, dp) + recur(n-2, dp);
    //     return dp[n];
    // }


    public int climbStairs(int n) {
        //Bottom-up approach  approach-Tabulation
      if(n<=2){
        return n;
      }
      int dp[]=new int[n+1];
      dp[1]=1;
      dp[2]=2;

      for(int state=3;state<=n;state++){
        dp[state]=dp[state-1]+dp[state-2];
      }
      return dp[n];
    }
}