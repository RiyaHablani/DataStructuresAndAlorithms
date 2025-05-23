class Solution {
    public int maxOperations(int[] nums, int k) {
        int count=0,i=0,j=nums.length-1;
        Arrays.sort(nums);
        while(i<j){
            if((nums[i]+nums[j])==k){
                count++;
                i++;
                j--;
            }else if((nums[i]+nums[j])>k){
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}