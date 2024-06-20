class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        
        int count = 0;
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sortedArr[i];
            if (sum1 == sum2) {
                count++;
            }
        }
        
        return count;
    }
}