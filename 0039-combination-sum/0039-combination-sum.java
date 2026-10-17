class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(res,list,0,candidates,target,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> list,int index,int[] candidates,int target,int sum){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return; 
        }
        if (index == candidates.length || sum > target) {
            return;
        }
        list.add(candidates[index]);
        backtrack(res,list,index,candidates,target,sum+candidates[index]);
        list.remove(list.size()-1);
        backtrack(res,list,index+1,candidates,target,sum);

    }
}