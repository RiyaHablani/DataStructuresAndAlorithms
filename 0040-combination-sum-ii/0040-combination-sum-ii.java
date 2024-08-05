class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findSum(0, candidates,target, new ArrayList<>(), result);
        return result;
    }
    public static void findSum(int indx,int[] candidates,int target,List<Integer> ans,List<List<Integer>> result){
        if (target == 0) {
            List<Integer> combination = new ArrayList<>(ans);
            result.add(combination);
            return;
        }
        if(target<0){
            return;
        }
        for(int i=indx;i<candidates.length;i++){
             // Skip duplicates
            if (i > indx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            ans.add(candidates[i]);
            findSum(i+1,candidates,target-candidates[i],ans,result);
            ans.remove(ans.size()-1);
        }
    }
}