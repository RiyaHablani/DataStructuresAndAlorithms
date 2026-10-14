class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit to the window
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If we have more than 2 fruit types,
            // move left until only 2 types remain
            while (map.size() > 2) {

                int fruit = fruits[left];

                map.put(fruit, map.get(fruit) - 1);

                // If no fruit of this type remains,
                // remove this type from the map
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }

                left++;
            }

            // Current window has at most 2 fruit types
            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}