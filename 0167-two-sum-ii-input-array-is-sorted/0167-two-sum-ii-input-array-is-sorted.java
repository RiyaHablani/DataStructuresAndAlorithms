class Solution {
    public int[] twoSum(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int arr[]=new int[2];
        while(low<high){
            if((nums[low]+nums[high])<target){
                low++;
            }else if((nums[low]+nums[high])>target){
                high--;
            }else{
                break;
            }  
        }
        arr[0]=low+1;
        arr[1]=high+1;
        return arr;
    }
}