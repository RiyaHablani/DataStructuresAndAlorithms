class Solution {
    public int maxProduct(int[] nums) {
        int max=-1,smax=-1,pro=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<max && nums[i]>smax){
                smax=nums[i];
            }
            if(nums[i]>=max){
                smax=max;
                max=nums[i];
            }
        }
        pro=(max-1)*(smax-1);
        return pro;
    }
}