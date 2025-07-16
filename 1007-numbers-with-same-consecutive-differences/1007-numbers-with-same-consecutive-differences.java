class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();

        // Start building numbers with digits from 1 to 9 (leading 0 not allowed)
        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, i, k, result); // start DFS with 1 digit already used
        }

        // Convert the result list to an int[] array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    // Recursive DFS function to build valid numbers
    private void dfs(int n, int num, int k, List<Integer> result) {
        // Base case: if n == 0, the number has n digits, so add to result
        if (n == 0) {
            result.add(num);
            return;
        }

        int lastDigit = num % 10;  // get the last digit of the current number

        // Case 1: Try adding (lastDigit + k) if it's a valid digit (<= 9)
        if (lastDigit + k <= 9) {
            int nextNum = num * 10 + (lastDigit + k); // append new digit
            dfs(n - 1, nextNum, k, result); // reduce n and recurse
        }

        // Case 2: Try adding (lastDigit - k) if it's valid and k != 0 (to avoid duplicates)
        if (k != 0 && lastDigit - k >= 0) {
            int nextNum = num * 10 + (lastDigit - k); // append new digit
            dfs(n - 1, nextNum, k, result); // reduce n and recurse
        }
    }
}
