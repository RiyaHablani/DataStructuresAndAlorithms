class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        // Iterate through all the people before the k-th person and calculate their contribution to the time
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);  // For everyone before or at k, they take tickets[i] seconds
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);  // For everyone after k, they take a reduced time
            }
        }

        return time;
    }
}
