class Solution {
    public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int quickSelect(int[] nums, int left, int right, int k) {
		int p = left + ((right - left) / 2);
		if (right > left) {
			int r2 = right;
			while (left != right) {
				if (left != p) {
					if (nums[left] > nums[p]) {
						swap(nums, left, p);
						p = left;
					} else {
						left++;
					}
				}
				if (right != p) {
					if (nums[right] < nums[p]) {
						swap(nums, right, p);
						p = right;
					} else {
						right--;
					}
				}
			}
			if ((nums.length - k) == p) {
				return nums[p];
			} else {
				if ((nums.length - k) < p) {
					return quickSelect(nums, 0, p - 1, k);
				} else {
					return quickSelect(nums, p + 1, r2, k);
				}
			}
		}
		return nums[p];
	}
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length -1, k);
    }
}