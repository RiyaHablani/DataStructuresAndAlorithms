class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
         // Step 1: Create an array of pairs (number of soldiers, row index)
        int[][] soldierCount = new int[mat.length][2];
        
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // Soldiers are on the left, so we can stop counting when we hit a 0
                }
            }
            soldierCount[i][0] = count; // Number of soldiers
            soldierCount[i][1] = i;    // Row index
        }
        
        // Step 2: Sort the array by soldier count, then by index
        Arrays.sort(soldierCount, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Compare by soldier count
            } else {
                return Integer.compare(a[1], b[1]); // Compare by row index
            }
        });
        
        // Step 3: Collect the first k indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount[i][1];
        }
        
        return result;
    }
}