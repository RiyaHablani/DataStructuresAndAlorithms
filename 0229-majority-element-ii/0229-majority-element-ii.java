class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // Two possible majority candidates
        int candidate1 = 0, candidate2 = 0;

        // Their respective counts
        int count1 = 0, count2 = 0;

        // ----------------------------
        // First Pass: Find potential candidates
        // ----------------------------
        for (int num : nums) {

            // If current number matches first candidate,
            // increase its count.
            if (num == candidate1) {
                count1++;
            }

            // Else if it matches second candidate,
            // increase its count.
            else if (num == candidate2) {
                count2++;
            }

            // If first candidate has no votes left,
            // assign current number as new candidate.
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }

            // If second candidate has no votes left,
            // assign current number as new candidate.
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }

            // Current number is different from both candidates,
            // so cancel one vote from each candidate.
            else {
                count1--;
                count2--;
            }
        }

        // ----------------------------
        // Second Pass: Verify candidates
        // ----------------------------
        count1 = 0;
        count2 = 0;

        // Count actual frequencies of both candidates.
        for (int num : nums) {

            if (num == candidate1)
                count1++;

            else if (num == candidate2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();

        // Add candidate1 if it appears more than n/3 times.
        if (count1 > nums.length / 3)
            ans.add(candidate1);

        // Add candidate2 if it appears more than n/3 times.
        if (count2 > nums.length / 3)
            ans.add(candidate2);

        return ans;
    }
}