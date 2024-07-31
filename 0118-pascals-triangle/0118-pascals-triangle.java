class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            long ansValue = 1; 

            for (int col = 1; col <= row; col++) {
                rowList.add((int) ansValue); 
                ansValue = ansValue * (row - col) / col;
            }
            ans.add(rowList);
        }
        return ans;
    }
}