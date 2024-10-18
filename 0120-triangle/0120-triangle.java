class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[] dp= new int[m];
        for(int j=0;j<m;j++){
            dp[j]=triangle.get(m-1).get(j);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}