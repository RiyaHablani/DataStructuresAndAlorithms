class Solution {
    public int longestOnes(int[] nums, int k) {
        int right=0,left=0,maxLength=0,count0=0;
        int n=nums.length;
        while(right<n){
            if(nums[right]==0){
                count0++;
            }
            if(count0>k){
                if(nums[left]==0){
                    count0--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}