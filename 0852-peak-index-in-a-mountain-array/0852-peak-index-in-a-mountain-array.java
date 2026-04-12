class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid!=0 && mid!=n-1 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]<arr[mid+1] && mid!=n-1){
                start=mid+1;
            }else if(arr[mid]>arr[mid+1] && mid!=0){
                end=mid-1;
            }
        }
        return -1;
    }
}