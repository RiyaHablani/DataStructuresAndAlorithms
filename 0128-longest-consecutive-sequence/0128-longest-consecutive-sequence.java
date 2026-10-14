class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxLen=0;
        for(Integer element:set){
            int prev=element-1;
            if(!set.contains(prev)){
                int len=1;
                int nextEle=element+1;
                while(set.contains(nextEle)){
                    len++;
                    nextEle++;
                }
                maxLen=Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}