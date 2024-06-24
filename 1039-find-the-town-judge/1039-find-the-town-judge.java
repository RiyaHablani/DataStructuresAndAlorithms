class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust == null || n <= 0) return -1;

        // Array to keep track of out-degrees (number of people each person trusts)
        int[] outDegrees = new int[n + 1];
        // Array to keep track of in-degrees (number of people who trust each person)
        int[] inDegrees = new int[n + 1];

        // Populate outDegrees and inDegrees arrays
        for (int[] t : trust) {
            outDegrees[t[0]]++;
            inDegrees[t[1]]++;
        }

        // Check for the person who is trusted by n-1 people and trusts no one
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }

        // If no such person is found, return -1
        return -1;
    }
}