class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findSum(0, candidates,target, new ArrayList<>(), result);
        return result;
    }
    static void findSum(int indx, int[] candidates, int target,List<Integer> ans, List<List<Integer>>result) {
        if (target == 0) {
            List<Integer> combination = new ArrayList<>(ans);
            result.add(combination);
            return;
        }
        if(target<0){
            return;
        }
        for(int i=indx;i<candidates.length;i++){
            ans.add(candidates[i]);
            findSum(i,candidates,target-candidates[i],ans,result);
            ans.remove(ans.size()-1);
        }        
    }
}