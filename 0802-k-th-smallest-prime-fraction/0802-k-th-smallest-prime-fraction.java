class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
      int n = arr.length;
        List<int[]> fractions = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                fractions.add(new int[]{arr[i], arr[j]});
            }
        }
        
        Collections.sort(fractions, (a, b) -> Double.compare((double) a[0] / a[1], (double) b[0] / b[1]));
        
        return fractions.get(k - 1);
    }
}