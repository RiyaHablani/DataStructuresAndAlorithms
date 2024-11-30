class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(0, candidates, current, result, target);
        return result;
    }

    private void combinationSumHelper(int index, int[] candidates, List<Integer> current, List<List<Integer>> result, int target) {
        // Base case: If the target is zero, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If we've reached the end of the array or target becomes negative, backtrack
        if (index == candidates.length || target < 0) {
            return;
        }

        // Include the current candidate
        current.add(candidates[index]);
        combinationSumHelper(index, candidates, current, result, target - candidates[index]);
        current.remove(current.size() - 1); // Backtrack

        // Exclude the current candidate and move to the next
        combinationSumHelper(index + 1, candidates, current, result, target);
    }
}
