class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int sum=0;
        int nums[]= new int[2];
        for(int i=0;i<arr.length;i++){
            int comp=target-arr[i];
            if(map.containsKey(comp)){
                nums[0]=map.get(comp);
                nums[1]=i;
            }
            map.put(arr[i],i);
        }
        return nums;
    }
}