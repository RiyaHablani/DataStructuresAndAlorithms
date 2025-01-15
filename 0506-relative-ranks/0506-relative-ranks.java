class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i=0;i<score.length;i++) {
            maxHeap.add(score[i]);
        }
        HashMap<Integer, String> rankMap = new HashMap<>();
        int rank = 1;
        while (!maxHeap.isEmpty()) {
            int topScore = maxHeap.poll();
            if (rank == 1) {
                rankMap.put(topScore, "Gold Medal");
            } else if (rank == 2) {
                rankMap.put(topScore, "Silver Medal");
            } else if (rank == 3) {
                rankMap.put(topScore, "Bronze Medal");
            } else {
                rankMap.put(topScore, String.valueOf(rank));
            }
            rank++;
        }
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = rankMap.get(score[i]);
        }
        
        return result;
    }
}