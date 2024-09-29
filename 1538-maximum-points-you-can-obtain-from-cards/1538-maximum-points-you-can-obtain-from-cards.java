class Solution {
    public int maxScore(int[] cardPoints, int k) 
    {
        int leftScore=0;
        int rightScore=0;
        int maxScore=0;

        for(int i=0;i<k;i++){
            //Adding all the score points till window size k
            leftScore+=cardPoints[i];
        }
        maxScore=leftScore; //Initially maxScore will be the left window 

        int j=cardPoints.length-1;//Right window pointer
        for(int i=k-1;i>=0;i--){
            
            //Removing the added last score from the left window
            leftScore=leftScore-cardPoints[i];
            //Addingthe first score from the right window
            rightScore=rightScore+cardPoints[j];
            //Checking the maxScore
            maxScore=Math.max(maxScore,leftScore+rightScore);
            j--;
        }
        return maxScore;
    }
}