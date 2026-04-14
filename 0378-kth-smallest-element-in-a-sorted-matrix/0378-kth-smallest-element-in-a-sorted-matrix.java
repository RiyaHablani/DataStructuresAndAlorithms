class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int R=matrix.length;
        int C=matrix[0].length;
        int N=R*C;
        int requiredSmallerElements=k-1;
        int start=matrix[0][0];
        int end=matrix[R-1][C-1];
        while(start<=end){
            int assumedkthElement=start+(end-start)/2;
            int smallerElements=findSmallerElements(matrix,assumedkthElement);
            if(smallerElements<=requiredSmallerElements){
                start=assumedkthElement+1;
            }else{
                end=assumedkthElement-1;
            }
        }
        return start;
    }
    public int findSmallerElements(int matrix[][],int assumedMatrix){
        int noOfSmallerElements=0;
        for(int i=0;i<matrix.length;i++){
            int start=0;
            int end=matrix[i].length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(matrix[i][mid]<=assumedMatrix){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
            noOfSmallerElements+=start;
        }
        return noOfSmallerElements;
    }
}