class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        if (trust.length < n - 1) return -1; // not enough edges to have a judge

        int[] score = new int[n + 1]; // in-degree minus out-degree
        for (int[] t : trust) {
            score[t[0]]--; // trusts someone
            score[t[1]]++; // is trusted by someone
        }
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) return i; // trusted by everyone else, trusts nobody
        }
        return -1;
    }
}