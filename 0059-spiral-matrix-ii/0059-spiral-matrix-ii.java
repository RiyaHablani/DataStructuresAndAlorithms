class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int startRow=0;
        int endRow=n-1;
        int startCol=0;
        int endCol=n-1;
        int val=1;
        while(startRow<=endRow && startCol<=endCol){
            //fill first Row
            for(int j=startCol;j<=endCol;j++){
                matrix[startRow][j]=val;
                val++;
            }
            startRow+=1;
            //fill end Col
            for(int i=startRow;i<=endRow;i++){
                matrix[i][endCol]=val;
                val++;
            }
            endCol-=1;
            if(startRow<=endRow){
            //fill last Row
            for(int j=endCol;j>=startCol;j--){
                matrix[endRow][j]=val;
                val++;
            }
            endRow-=1;
            }
            if(startCol<=endCol){
            //fill firstCol
            for(int i=endRow;i>=startRow;i--){
                matrix[i][startCol]=val;
                val++;
            }
            startCol+=1;
            }
        }
        return matrix;
    }
}