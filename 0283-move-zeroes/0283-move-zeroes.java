class Solution {
    public void moveZeroes(int[] arr) {
       int start = 0;
        int second = 1;

        while (second < arr.length) {
            if (arr[start] == 0 && arr[second] != 0) {
                int temp = arr[start];
                arr[start] = arr[second];
                arr[second] = temp;
                start++;
                second++;
            } else if (arr[start] == 0 && arr[second] == 0) {
                second++;
            } else {
                start++;
                second++;
            }
        }
    }
}