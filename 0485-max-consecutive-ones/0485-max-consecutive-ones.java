class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen=0;
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                len++;
                maxLen=Math.max(maxLen,len);
            }else{
                len=0;
            }
        }
        return maxLen;
    }
}