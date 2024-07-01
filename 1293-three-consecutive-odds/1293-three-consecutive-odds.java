class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int nums[]=new int[arr.length];
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                nums[j]=0;
            }else{
                nums[j]=1;
            }
            j++;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]==nums[i] && nums[i]==nums[i+1] && nums[i]==1){
                return true;
            }
        }
        return false;
    }
}