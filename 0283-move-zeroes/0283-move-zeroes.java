class Solution {
    public void moveZeroes(int[] arr) {
        int start = 0;

        for (int second = 0; second < arr.length; second++) {
            if (arr[second] != 0) {
                if (start != second) {
                    int temp = arr[start];
                    arr[start] = arr[second];
                    arr[second] = temp;
                }
                start++;
            }
        }
    }
}
