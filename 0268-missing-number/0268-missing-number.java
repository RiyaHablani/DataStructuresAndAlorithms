class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int givensum=0;
        int sum=n*(n+1)/2;
        for(int i=0;i<n;i++){
            givensum+=nums[i];
        }
        return sum-givensum;
    }
}