class Solution {
    public void rotate(int[][] matrix) {
        // 00 01 02
        // 10 11 12
        // 20 21 22

        //00 10 20
        //01 11 21
        //02 12 22

        //20 10 00
        //21 11 01
        //20 21 22
        int n=matrix.length;
        transpose(matrix,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
    public void transpose(int matrix[][],int n){
        for(int i=0;i<n;i++){ 
            for(int j=0;j<i;j++){ 
                int temp = matrix[i][j]; 
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = temp; 
            } 
        }
    }
}