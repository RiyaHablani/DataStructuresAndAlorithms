class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) map.put(card, map.getOrDefault(card, 0) + 1);

        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > 0) {
                for (int i = 1; i < groupSize; i++) {
                    if (map.getOrDefault(key + i, 0) < count) return false;
                    map.put(key + i, map.get(key + i) - count);
                }
            }
        }
        return true;
    }
}
