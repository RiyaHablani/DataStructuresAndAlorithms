public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        // Create an array to store the next greater elements for elements in nums2
        int[] nextGreater = new int[nums2.length];

        // Initialize the nextGreater array with -1
        for (int i = 0; i < nums2.length; i++) {
            nextGreater[i] = -1;
        }

        // Iterate through nums2 to find the next greater element for each element
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                nextGreater[index] = nums2[i];
            }
            stack.push(i);
        }

        // Iterate through nums1 to fill the result array
        for (int i = 0; i < nums1.length; i++) {
            int index = indexOf(nums2, nums1[i]);
            result[i] = nextGreater[index];
        }

        return result;
    }

    // Helper function to find the index of an element in an array
    private int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
