class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                result.add(list);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        result.add(list);
        
        int[][] mergedIntervals = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            mergedIntervals[i][0] = result.get(i).get(0);
            mergedIntervals[i][1] = result.get(i).get(1);
        }
        
        return mergedIntervals;
    }
}