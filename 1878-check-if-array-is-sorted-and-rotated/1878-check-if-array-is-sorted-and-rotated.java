class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]<nums[i]){
                count++;
            }
        }
        if(nums[nums.length-1]>nums[0]){
                count++;
        }
        if(count>1){
            return false;
        }
        return true;
    }
}