public class Solution{
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    // Sort both arrays to allow greedy matching
    Arrays.sort(players);
    Arrays.sort(trainers);

    int i = 0, j = 0, count = 0;
    // Use two pointers to match players and trainers greedily
    while (i < players.length && j < trainers.length) {
        if (players[i] <= trainers[j]) {
            count++; // Match found
            i++;
            j++;
        } else {
            j++; // Try next trainer for the current player
        }
    }
    return count;
    }
}