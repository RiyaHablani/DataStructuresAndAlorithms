class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals that come before the newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // Update the start and end of the newInterval to include the overlapping intervals
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged newInterval
        result.add(newInterval);

        // Add all remaining intervals that come after the newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result to a 2D array and return
        return result.toArray(new int[result.size()][]);
    }
}