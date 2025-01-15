class Solution {
    public int findKthLargest(int[] nums, int k) {
        // The kth largest element corresponds to the (n-k)th smallest index in sorted order
        int targetIdx = nums.length - k;

        // Use the Quickselect algorithm to find the target index
        return quickSelect(nums, 0, nums.length - 1, targetIdx);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIdx) {
        // Base case: if the left and right pointers meet, we have a single element
        if (left == right) {
            return nums[left];
        }

        // Choose the leftmost element as the pivot
        int pivot = nums[left];
        int low = left;  // Pointer to move forward from the left
        int high = right;  // Pointer to move backward from the right

        // Partition the array around the pivot
        while (low <= high) {
            // Move the 'low' pointer to the right until finding a value >= pivot
            while (low <= high && nums[low] < pivot) {
                low++;
            }
            // Move the 'high' pointer to the left until finding a value <= pivot
            while (low <= high && nums[high] > pivot) {
                high--;
            }
            // Swap elements if 'low' is still less than or equal to 'high'
            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }

        // After partitioning:
        // 'high' is the last index of the left (smaller) partition
        // 'low' is the first index of the right (larger) partition

        // If the target index is in the left partition, recursively search there
        if (targetIdx <= high) {
            return quickSelect(nums, left, high, targetIdx);
        }
        // If the target index is in the right partition, recursively search there
        else if (targetIdx >= low) {
            return quickSelect(nums, low, right, targetIdx);
        }
        // Otherwise, the pivot is the target element
        else {
            return nums[targetIdx];
        }
    }
}
