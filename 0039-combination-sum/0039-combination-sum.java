class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(0, candidates, current, result, target);
        return result;
    }

    private void combinationSumHelper(int index, int[] candidates, List<Integer> current, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]); // Choose the candidate
                combinationSumHelper(i, candidates,current, result, target - candidates[i]); // Recur with updated target
                current.remove(current.size() - 1); // Backtrack
            }
        }  
    }
}
