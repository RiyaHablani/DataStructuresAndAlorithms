class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans=new ArrayList<>();
       List<Integer> ds=new ArrayList<>();
       solve(0,candidates,target,ans,ds);
       return ans;
    }
    void solve(int start,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(target<0)
          return;
        for(int i=start;i<candidates.length;i++){
            ds.add(candidates[i]);
            solve(i,candidates,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}