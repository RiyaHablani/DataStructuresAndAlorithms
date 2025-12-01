class TopVotedCandidate {
    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;
        leaders = new int[n];

        Map<Integer, Integer> count = new HashMap<>();
        int currentLeader = -1;
        int maxVotes = 0;

        for (int i = 0; i < n; i++) {
            int p = persons[i];
            count.put(p, count.getOrDefault(p, 0) + 1);

            // update leader: tie → most recent vote wins
            if (count.get(p) >= maxVotes) {
                maxVotes = count.get(p);
                currentLeader = p;
            }

            leaders[i] = currentLeader;
        }
    }

    public int q(int t) {
        // binary search for the largest index i where times[i] <= t
        int left = 0, right = times.length - 1;

        while (left < right) {
            int mid = left + (right + 1 - left) / 2; // upper mid to avoid infinite loop
            if (times[mid] <= t) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return leaders[left];
    }
}
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */