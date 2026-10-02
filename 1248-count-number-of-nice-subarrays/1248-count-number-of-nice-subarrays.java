class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int subarray = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                count++;
            }
            if (map.containsKey(count - k)) {
                subarray += map.get(count - k);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return subarray;
    }
}