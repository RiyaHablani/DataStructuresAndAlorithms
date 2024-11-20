class Solution {
    public void sortColors(int[] nums) {
        int count0=0,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count0++;
            }else if(nums[i]==1){
                count1++;
            }else{
                count2++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
//2 0 2 1 1 0 //2 0 1
//0 0 2 1 1 2
//0 0 1 1 2 2