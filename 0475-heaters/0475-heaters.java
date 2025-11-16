class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {
            // find the closest heater to this house
            int dist = getNearestHeater(house, heaters);
            radius = Math.max(radius, dist);
        }

        return radius;
    }

    private int getNearestHeater(int house, int[] heaters) {
        int left = 0;
        int right = heaters.length - 1;

        // Binary search to find the first heater >= house
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (heaters[mid] < house) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int dist1 = (left < heaters.length) ? Math.abs(heaters[left] - house) : Integer.MAX_VALUE;
        int dist2 = (right >= 0) ? Math.abs(heaters[right] - house) : Integer.MAX_VALUE;

        return Math.min(dist1, dist2);
    }
}
