class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        int n=arr.length;
        int i=0;
        //find increasing sequence
        while(i<n-1){
            if(arr[i]<arr[i+1]){
                i++;
            }else{
                break;
            }
        }
        if(i==0 || i==n-1){
            return false;
        }
        //find all decreasing seq (find the end of the array)
        while(i<n-1){
            if(arr[i]>arr[i+1]){
                i++;
            }else{
                break;
            }
        }
        return (i==n-1);
    }
}