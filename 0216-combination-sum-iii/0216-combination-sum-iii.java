class Solution {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSumHelper(1, current, result, target,k);
        return result;
    }

    private void combinationSumHelper(int index, List<Integer> current, List<List<Integer>> result, int target,int k) {
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
         if (current.size() > k || target < 0) return;
        for (int i = index; i <=9; i++) {
            if (i <= target) {
                current.add(i); // Choose the candidate
                combinationSumHelper(i+1, current, result, target -i,k); // Recur with updated target
                current.remove(current.size() - 1); // Backtrack
            }
        }  
    }
}