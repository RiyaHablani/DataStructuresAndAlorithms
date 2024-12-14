class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[]=new int[nums.length];
        int low=0,high=nums.length-1,k=nums.length-1;
        while(low<=high){
            if(Math.abs(nums[low])<=Math.abs(nums[high])){
                arr[k]=nums[high]*nums[high];
                high--;
            }else if(Math.abs(nums[low])>Math.abs(nums[high])){
                arr[k]=nums[low]*nums[low];
                low++;
            }
            k--;
        }
        return arr;
    }
}