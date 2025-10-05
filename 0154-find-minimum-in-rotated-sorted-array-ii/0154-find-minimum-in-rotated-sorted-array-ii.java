class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int minEle=Integer.MAX_VALUE;

        while(start<=end){
            int mid=start+(end-start)/2;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                minEle=Math.min(minEle,nums[start]);
                start++;
                end--;
                continue; 
            }
            if(nums[start]<=nums[mid]){
                minEle=Math.min(minEle,nums[start]);
                start=mid+1;
            }else{
                minEle=Math.min(minEle,nums[mid]);
                end=mid-1;
            }
        }
        return minEle;
    }
}