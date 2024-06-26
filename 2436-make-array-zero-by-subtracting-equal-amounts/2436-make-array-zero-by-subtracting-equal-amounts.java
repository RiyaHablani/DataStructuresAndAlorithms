class Solution {
    public int minimumOperations(int[] nums) {
        int operations=0;

        while(true){
            int min=Integer.MAX_VALUE;
            boolean allZero=true;

            for(int i=0;i<nums.length;i++){
                if (nums[i] > 0) {
                    min = Math.min(min, nums[i]);
                    allZero = false;
                }
            }
            if (allZero) {
                break;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= min;
                }
            }
            operations++;
        }
        return operations;
    }
}