class Solution {
    public boolean checkIfExist(int[] arr) {
        // Step 1: Sort the array so binary search can be used
        Arrays.sort(arr);

        // Step 2: For each element arr[i], search for 2 * arr[i]
        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];

            // Search for target using binary search
            if (binarySearch(arr, target, i)) {
                return true; // found valid pair
            }
        }
        return false; // no pair found
    }

    // Binary search function
    // skipIndex = index of the element we should NOT match with itself
    private boolean binarySearch(int[] arr, int target, int skipIndex) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we found the target
            if (arr[mid] == target) {

                // Make sure it's NOT the same index (i != j condition)
                if (mid != skipIndex) return true;

                // Even if mid == skipIndex, check neighbors in case
                // of duplicates (example: [0,0] => 0 == 2*0)
                if (mid + 1 < arr.length && arr[mid + 1] == target) return true;
                if (mid - 1 >= 0 && arr[mid - 1] == target) return true;

                return false;
            }

            // Normal binary search movement
            if (arr[mid] < target) {
                left = mid + 1;  // go right
            } else {
                right = mid - 1; // go left
            }
        }
        return false; // target not found
    }
}
