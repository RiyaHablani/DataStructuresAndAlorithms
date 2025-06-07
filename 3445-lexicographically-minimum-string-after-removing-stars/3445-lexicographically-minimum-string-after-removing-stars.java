class Solution {
    public static String clearStars(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        boolean[] removed = new boolean[n];

        int[][] indexStore = new int[26][n];
        int[] tops = new int[26]; 

        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '*') {
                removeStar(removed, indexStore, tops);
            } else {
                int idx = c - 'a';
                indexStore[idx][tops[idx]++] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!removed[i] && arr[i] != '*') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }

    static void removeStar(boolean[] removed, int[][] indexStore, int[] tops) {
        for (int i = 0; i < 26; i++) {
            if (tops[i] > 0) {
                int idx = indexStore[i][--tops[i]];
                removed[idx] = true;
                return;
            }
        }
    }
}