class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum=sum/2;
        int dp[][]= new int[n][sum+1];
        for(int row[]:dp)
           Arrays.fill(row,-1);
        return canPartitionUtil(n-1,sum,nums,dp);
    }
    public static boolean canPartitionUtil(int indx,int target,int[] arr,int[][] dp){
        if(target==0){
            return true;
        }
        if(indx==0){
            return arr[0]==target;
        }
        if(dp[indx][target]!=-1){
            return dp[indx][target]==1;
        }
        boolean notTaken=canPartitionUtil(indx-1,target,arr,dp);

        boolean taken=false;
        if(arr[indx]<=target){
            taken=canPartitionUtil(indx-1,target-arr[indx],arr,dp);
        }
        dp[indx][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }
}