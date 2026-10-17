class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(res, list, 0, candidates, target);

        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list,int index, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            backtrack(res, list, i + 1, candidates,target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}