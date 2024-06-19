class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        int i = 0, j = tokens.length - 1;

        Arrays.sort(tokens);

        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}