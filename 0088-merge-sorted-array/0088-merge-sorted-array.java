import java.util.Arrays;

class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                if (left < m && right >= m) {
                    swapIfGreater(arr1, arr2, left, right - m);
                }
                else if (left >= m) {
                    swapIfGreater(arr2, arr2, left - m, right - m);
                }
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
        for (int i = 0; i < n; i++) {
            arr1[m + i] = arr2[i];
        }
    }
    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
