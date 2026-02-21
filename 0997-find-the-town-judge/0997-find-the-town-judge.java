class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n + 1]; // in-degree minus out-degree
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            score[a]--;   // a trusts someone -> not judge
            score[b]++;   // b is trusted by a
        }
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) return i; // trusted by everyone else, trusts nobody
        }
        return -1;
    }
}