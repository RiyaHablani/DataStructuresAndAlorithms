class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        // Loop through the array 'time'
        for (int i = 0; i < time.length; i++) {
            // If the value at time[i] is greater than or equal to 60, reduce it to its remainder when divided by 60
            if (time[i] >= 60)
                time[i] %= 60;
        }
        
        // Create a HashMap to store the frequency of remainders when divided by 60
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Loop through the array 'time' again
        for (int i = 0; i < time.length; i++) {
            // If the current value is exactly divisible by 60 and there exists a previous value in the map, increment 'count' by the frequency of that value in the map
            if (time[i] == 0 && map.containsKey(time[i])) {
                count += map.get(time[i]);
            }
            // If there exists a value in the map such that (60 - time[i]) is a key, increment 'count' by the frequency of that value in the map
            if (map.containsKey(60 - time[i])) {
                count += map.get(60 - time[i]);
            }
            // Update the frequency of the current remainder in the map
            map.put(time[i], map.getOrDefault(time[i], 0) + 1);
        }
        
        // Return the final count, which represents the number of pairs with a sum divisible by 60
        return count;
    }
}
