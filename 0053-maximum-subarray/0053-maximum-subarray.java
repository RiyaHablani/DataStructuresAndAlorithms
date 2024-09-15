class Solution {
    public int maxSubArray(int[] arr) {
        int ms = Integer.MIN_VALUE;
        int cs= 0;
        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (ms < cs)
                ms = cs;
            if (cs < 0)
                cs = 0;
        }
        return ms;
    }
}
