class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();  // Use ArrayList instead of LinkedList
        int i = 0;
        
        // Add all intervals that end before the newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0])
            result.add(intervals[i++]);
        
        // Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the merged interval
        result.add(newInterval);
        
        // Add the rest of the intervals
        while (i < intervals.length)
            result.add(intervals[i++]);

        // Convert result to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}