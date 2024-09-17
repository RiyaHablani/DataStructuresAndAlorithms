class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length < 4) return new ArrayList<>();
        
        Arrays.sort(nums);
        int size = nums.length;

        for (int i = 0; i < size - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            for (int j = i + 1; j < size - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates
                
                int l = j + 1;
                int k = size - 1;

                while (l < k) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[k];

                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
                        while (l < k && nums[l] == nums[l + 1]) l++; // Skip duplicates
                        while (l < k && nums[k] == nums[k - 1]) k--; // Skip duplicates
                        l++;
                        k--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}