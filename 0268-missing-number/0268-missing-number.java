class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;//2
        while(start<=end){
            int mid=start+(end-start)/2;//1,2
            if(nums[mid]==mid){
                start=mid+1;//2
            }else{
                end=mid-1;//1
            }
        }
        return start;
    }
}
