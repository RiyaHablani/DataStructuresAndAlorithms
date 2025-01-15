class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) {
            if (num > 0) {
                uniqueNumbers.add(num);
            }
        }

        return uniqueNumbers.size();
    }
}