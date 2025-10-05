class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }//left side is sorted
            else if(nums[start]<=nums[mid]){
                //can ans be found in left side
                if(nums[start]<=target && target<nums[mid]){
                    end=mid-1;
                }else{
                   start=mid+1;
                }
                
            }//right side is sorted
            else{
                //can ans be found in right side
                if(nums[mid] < target && target <= nums[end]){
                    start=mid+1;
                }else{
                   end=mid-1;
                }  
            } 
        }
        return -1;
    }
}