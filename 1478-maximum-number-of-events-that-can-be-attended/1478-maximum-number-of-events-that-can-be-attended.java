import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // Min-heap for event end days
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, n = events.length, res = 0;
        // Find the last day
        int lastDay = 0;
        for (int[] e : events) lastDay = Math.max(lastDay, e[1]);
        // Iterate through each day
        for (int day = 1; day <= lastDay; day++) {
            // Add all events that start today
            while (i < n && events[i][0] == day)
                pq.offer(events[i++][1]);
            // Remove all events that have ended
            while (!pq.isEmpty() && pq.peek() < day)
                pq.poll();
            // Attend the event that ends earliest
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}
