class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // If the total number of cards is not divisible by the group size, 
        // it's impossible to divide them into groups of 'groupSize'
        if (hand.length % groupSize != 0) return false;

        // Use a TreeMap to store the frequency of each card.
        // TreeMap ensures that the keys (card values) are in sorted order.
        Map<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            // Count the occurrences of each card
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Iterate over the sorted card values in the map
        for (int key : map.keySet()) {
            int count = map.get(key); // Get the count of the current card
            if (count > 0) { // Process only if this card is still available
                // Check for the next `groupSize - 1` cards
                for (int i = 1; i < groupSize; i++) {
                    // If there are not enough cards to form a group, return false
                    if (map.getOrDefault(key + i, 0) < count) return false;
                    // Deduct the count of the required card from the map
                    map.put(key + i, map.get(key + i) - count);
                }
            }
        }
        
        // If all groups are formed successfully, return true
        return true;
    }
}
