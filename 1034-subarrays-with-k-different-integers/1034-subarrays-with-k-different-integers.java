class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int l=0,r=0,count=0,n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}