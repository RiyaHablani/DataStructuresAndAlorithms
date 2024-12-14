class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=matrix[0].length-1;
        if(low<0 || high<0 || low>=matrix.length || high>=matrix[low].length || matrix==null){
                return false;
        }
        //if(matrix==null || matrix.length<1 || matrix[0].length <1) return false;
        while(low<=matrix.length-1 && high>=0){
            if(matrix[low][high]==target) return true;
            else if(matrix[low][high]<target) low++;
            else high--;
        }
        return false;
    }
}