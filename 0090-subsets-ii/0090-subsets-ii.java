class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList,new ArrayList<>(),nums,0);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultSets,List<Integer> tempSet,int[] nums,int start){
       if(resultSets.contains(tempSet))
          return;
        resultSets.add(new ArrayList<>(tempSet));
         for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backtrack(resultSets, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
         }
    }
}