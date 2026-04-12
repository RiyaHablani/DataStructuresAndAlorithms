class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        int first=binarySearch(nums,target,true);
        int end=binarySearch(nums,target,false);
        res[0]=first;
        res[1]=end;
        return res;
    }public int binarySearch(int[] nums,int target,boolean isFirst){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans=mid;
                if(isFirst){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else if(nums[mid]<target){
                start=mid+=1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}