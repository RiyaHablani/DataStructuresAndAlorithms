class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMod = new int[n + 1];
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixMod[i + 1] = sum % k;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i <= n; i++) {
            if (mp.containsKey(prefixMod[i])) {
                if (i - mp.get(prefixMod[i]) >= 2) {
                    return true;
                }
            } else {
                mp.put(prefixMod[i], i);
            }
        }
        
        return false;
    }
}