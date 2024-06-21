class Solution {
    public int[] diStringMatch(String s) {
        int k = s.length(), m = 0;
        int[] arr = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                arr[i] = m++;
            } else {
                arr[i] = k--;
            }
        }
        arr[s.length()] = m;  // At the end, m and k will be equal and should be the remaining value
        return arr;
    }
}