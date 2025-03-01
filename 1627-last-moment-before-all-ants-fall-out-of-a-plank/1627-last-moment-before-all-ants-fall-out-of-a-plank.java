class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeftTime = 0;
        int maxRightTime = 0;

        // Find max time for left-moving ants
        for (int position : left) {
            maxLeftTime = Math.max(maxLeftTime, position);
        }

        // Find max time for right-moving ants
        for (int position : right) {
            maxRightTime = Math.max(maxRightTime, n - position);
        }

        // Maximum of both gives the time when the last ant falls
        return Math.max(maxLeftTime, maxRightTime);
    }
}