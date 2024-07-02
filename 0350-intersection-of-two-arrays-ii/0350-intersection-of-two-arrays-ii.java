class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        // Add elements of nums1 to list
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        
        // Find intersection elements
        for (int i = 0; i < nums2.length; i++) {
            if (list.contains(nums2[i])) {
                res.add(nums2[i]);
                list.remove(Integer.valueOf(nums2[i])); // Remove to handle duplicates correctly
            }
        }
        
        // Convert List<Integer> to int[]
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
}