class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Initialize a new ArrayList from current
        ArrayList<Integer> subset = new ArrayList<>(current);
        // Add the subset to result
        result.add(subset);

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]); // Include this element
            generateSubsets(i + 1, nums, current, result); // Recur with the next index
            current.remove(current.size() - 1); // Backtrack
        }
    }
}