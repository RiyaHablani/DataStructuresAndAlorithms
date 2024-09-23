class Solution {
    public void rotate(int[] nums, int k) {
        int j=0;
        int arr[]= new int[nums.length];
        k = k % nums.length;
        for(int i=nums.length-k;i<nums.length;i++){
            arr[j]=nums[i];
            j++;
        }
        for(int i=0;i<nums.length-k;i++){
            arr[j]=nums[i];
            j++;
        }
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
    }
}