class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // Sort the input array to handle duplicates
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return; // If remaining sum becomes negative, terminate
        else if (remain == 0) list.add(new ArrayList<>(tempList)); // If remaining sum becomes zero, add the current combination to the list
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1); // Recur with updated sum and start index
                tempList.remove(tempList.size() - 1); // Backtrack by removing the last added element
            }
        }
    }
}
