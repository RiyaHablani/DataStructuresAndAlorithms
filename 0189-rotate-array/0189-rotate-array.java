class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,nums.length-k,nums.length-1);//4,6
        reverse(nums,0,nums.length - k -1);//0,3
        reverse(nums,0,nums.length-1);//0,6
    }
    public static void reverse(int nums[],int first,int second){
        int swap;
        while (first < second){
            swap=nums[first];
            nums[first]=nums[second];
            nums[second]=swap;
            first++;
            second--;
        }
    }
}
//1 2 3 4 7 6 5
//4 3 2 1 7 6 5
// 5 6 7 1 2 3 4