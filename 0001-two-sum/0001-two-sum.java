class Solution {
    public int[] twoSum(int[] nums, int target) {
     int[] res= new int[2];
     Map<Integer,Integer> map = new HashMap<>();
    int n=nums.length;
     for(int i=0;i<n;i++){
         int complement=target-nums[i];
         if(map.containsKey(complement)){
             res[1]=i;
             res[0]=map.get(complement);
             break;
         }
         map.put(nums[i],i);
     }
     return res;
    }
}