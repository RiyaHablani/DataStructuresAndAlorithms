class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int nums[]= new int[nums1.length+nums2.length];
        int k=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums[k]=nums1[i];
                i++;
                k++;
            }else{
                nums[k]=nums2[j];
                j++;
                k++;
            }
        }

        while (i < nums1.length) {
            nums[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            nums[k++] = nums2[j++];
        }

        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2];
        } else {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0;
        }
    }
}