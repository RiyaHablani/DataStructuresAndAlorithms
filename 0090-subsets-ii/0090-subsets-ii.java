class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(res, list, 0, nums);

        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list,int index, int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
        list.add(nums[i]);
        backtrack(res,list,i+1,nums);
        list.remove(list.size()-1);
        }
    }
}