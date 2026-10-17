class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(res,list,1,k,n,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> list,int index,int k,int n,int sum){
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=index;i<=9;i++){
            //to make fast
            if (sum + i > n) break;
            list.add(i);
            backtrack(res,list,i+1,k,n,sum+i);
            list.remove(list.size()-1);
        }
    }
}