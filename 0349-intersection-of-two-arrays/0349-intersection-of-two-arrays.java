class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            int target = nums2[i];
            if (set.contains(target)) continue;

            int left = 0;
            int right = nums1.length-1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums1[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid-1;
                }
            }
            if (left < nums1.length && nums1[left] == target) {
                set.add(target);
            }
        }
        int[] ans = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            ans[idx++] = num;
        }
        return ans;
    }
}
