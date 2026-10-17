class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(res,list,nums,0);
        return res;
    }
    public void backtrack(List<List<Integer>> res,List<Integer> list,int[] nums,int index){
        if(index==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(res,list,nums,index+1);
        list.remove(list.size()-1);
        backtrack(res,list,nums,index+1);
    }
}