class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            boolean frontDirection = nums[i]>=0;
            
            int currentPosition = i;
            int fastPosition = i;
            
            while(true) {
                currentPosition = getNextPosition(nums, currentPosition, frontDirection);
                
                if(currentPosition==-1) {
                    break;
                }
                
                fastPosition = getNextPosition(nums, fastPosition, frontDirection);
                
                if(fastPosition==-1) {
                    break;
                }
                
                fastPosition = getNextPosition(nums, fastPosition, frontDirection);
                
                if(fastPosition==-1) {
                    break;
                }
                
                if(currentPosition == fastPosition) {
                    return true;
                }
                
            }
            
        }
        return false;
    }

    public  int getNextPosition(int[] nums, int index, boolean frontDirection) {
        
        
        int nextIndex = (nums[index] + index)%nums.length;
        if(nextIndex<0) {
            nextIndex = nums.length + nextIndex;
        }
        
        if(index==nextIndex) {
            return -1;
        }
        
        boolean direction =  nums[nextIndex]>=0;
        
        if(direction!=frontDirection) {
            return -1;
        }
        
        return nextIndex;
    }
}