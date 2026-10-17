class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        int rsb=xor&(-xor);
        int xorA=0;
        int xorB=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i]&rsb)==0){
                xorA^=nums[i];
            }else{
                xorB^=nums[i];
            }
        }
        return new int[]{xorA,xorB};
    }
}