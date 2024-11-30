class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(0, nums, current, result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            current.add(nums[i]); // Include the current element
            generateSubsets(i + 1, nums, current, result); // Recurse for the next index
            current.remove(current.size() - 1); // Backtrack to remove the current element
        }
    }
}