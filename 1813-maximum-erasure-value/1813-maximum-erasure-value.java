class Solution {
    public int maximumUniqueSubarray(int[] nums) {        
	int maxScore = 0, currScore = 0;
	Set<Integer> set = new HashSet<>();

	for (int i=0, j=0; j<nums.length; j++) {
		while (!set.add(nums[j])) {//checks for unique element,if it is already present
			currScore -= nums[i];
			set.remove(nums[i++]);
		}
		currScore += nums[j];
		maxScore = Math.max(maxScore, currScore);
	}

	return maxScore;
}
}