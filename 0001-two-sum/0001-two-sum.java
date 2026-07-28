class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(map.containsKey(comp)){
                arr[0]=map.get(comp);
                arr[1]=i;
            }
            map.put(nums[i],i);
        }
        return arr;
    }
}