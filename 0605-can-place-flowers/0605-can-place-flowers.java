class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Check if the current position and its neighbors are empty
                boolean canPlace = true;
                if (i > 0 && flowerbed[i - 1] == 1) { // check left neighbor
                    canPlace = false;
                }
                if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) { // check right neighbor
                    canPlace = false;
                }
                
                if (canPlace) {
                    flowerbed[i] = 1; // place a flower
                    count++;
                }
                
                if (count >= n) {
                    return true;
                }
            }
        }
        
        return count >= n;
    }
}