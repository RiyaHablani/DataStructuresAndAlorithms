class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int i=0;
        int maxIndex=0;
        while(i<=maxIndex){
            maxIndex=Math.max(maxIndex,i+nums[i]);
            if(maxIndex>=n-1){
                return true;
            }
            i++;
        }
        return false;
    }
}