class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length,posIndex=0,negIndex=1;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                res[posIndex]=nums[i];
                posIndex=posIndex+2;
            }else{
                res[negIndex]=nums[i];
                negIndex=negIndex+2;
            }
        }
        return res;
    }
}