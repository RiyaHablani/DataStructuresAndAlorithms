class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=nums.length-1;
        int minElement=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[start]<=nums[mid]){
                minElement=Math.min(minElement,nums[start]);
                start=mid+1;
            }else{
                minElement=Math.min(minElement,nums[mid]);
                end=mid-1;
            }
        }
        return minElement;
    }
}