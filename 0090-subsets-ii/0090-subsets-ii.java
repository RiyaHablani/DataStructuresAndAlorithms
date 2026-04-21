class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        subsets(0,nums,current,res);
        return res;
    }
    private void subsets(int index,int[] nums,List<Integer> current,List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList<>(current));
            return;
        }
        //include
        current.add(nums[index]);
        //pick
        subsets(index+1,nums,current,res);
        //remove
        current.remove(current.size()-1);
        //no pick
        //remove all duplicates
        while((index+1)<nums.length && nums[index]==nums[index+1]) index++;
        subsets(index+1,nums,current,res);
    }
}