import java.util.ArrayList;

class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }
        
        while (right <= high) {
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }
    }

    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += countPairs(arr, low, mid, high);
            merge(arr, low, mid, high);
        }
        return count;
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > (long) 2 * arr[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }
}
