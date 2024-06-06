class Solution {
    public int minimumChairs(String s) {
        int currentOccupancy = 0;
        int maxOccupancy = 0;

        for (char event : s.toCharArray()) {
            if (event == 'E') {
                currentOccupancy++;
            } else {
                currentOccupancy--;
            }
            if (currentOccupancy > maxOccupancy) {
                maxOccupancy = currentOccupancy;
            }
        }

        return maxOccupancy;
    }
}