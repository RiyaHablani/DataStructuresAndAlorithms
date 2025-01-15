class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length; // Length of the score array
        int maxScore = 0;
        
        // Find the highest score
        for (int i = 0; i < n; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }
        
        // Create an array to map scores to their index in the result
        int[] score2Index = new int[maxScore + 1];
        
        // Store each score's index (1-based)
        for (int i = 0; i < n; i++) {
            score2Index[score[i]] = i + 1;
        }
        
        String[] ans = new String[n]; // Array to store the results
        int place = 1; // Ranking starts from 1
        
        // Start from the highest score and assign ranks
        for (int i = maxScore; i >= 0; i--) {
            if (score2Index[i] == 0) continue; // Skip if the score doesn't exist
            
            int index = score2Index[i] - 1; // Get original index of the score
            
            // Assign medals or ranks based on place
            if (place == 1) ans[index] = "Gold Medal";
            else if (place == 2) ans[index] = "Silver Medal";
            else if (place == 3) ans[index] = "Bronze Medal";
            else ans[index] = String.valueOf(place);
            
            place++; // Move to the next rank
        }
        
        return ans; // Return the array with ranks
    }
}
