class MyCalendar {
    List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    public boolean book(int start, int end) {
        // Check overlap with every stored event
        for (int i = 0; i < events.size(); i++) {
            int[] e = events.get(i);   // get the i-th event
            int s = e[0];              // event start
            int en = e[1];             // event end
            // Condition for overlap:
            // start1 < end2  AND  start2 < end1
            if (start < en && s < end) {
                return false;          // overlap → cannot book
            }
        }
        // If no overlap, add event
        events.add(new int[]{start, end});
        return true;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */