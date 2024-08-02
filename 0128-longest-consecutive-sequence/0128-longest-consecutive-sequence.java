class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}