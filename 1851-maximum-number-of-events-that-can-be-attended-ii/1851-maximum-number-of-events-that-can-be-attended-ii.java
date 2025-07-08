// Import required packages
import java.util.*;

// Main class
public class Solution {
    // DP memoization table
    int[][] memo;

    // Helper to perform binary search to find next non-overlapping event
    private int findNext(int[][] events, int idx, int currEnd) {
        int left = idx, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] > currEnd) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // Main DP function
    private int dp(int[][] events, int idx, int k) {
        if (k == 0 || idx == events.length) return 0;
        if (memo[idx][k] != -1) return memo[idx][k];
        // Skip current event
        int skip = dp(events, idx + 1, k);
        // Take current event
        int nextIdx = findNext(events, idx + 1, events[idx][1]);
        int take = events[idx][2] + dp(events, nextIdx, k - 1);
        return memo[idx][k] = Math.max(skip, take);
    }

    // Main function
    public int maxValue(int[][] events, int k) {
        // Sort events by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        memo = new int[events.length][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dp(events, 0, k);
    }
}