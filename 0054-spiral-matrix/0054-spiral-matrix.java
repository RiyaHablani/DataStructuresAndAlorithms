public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list= new ArrayList<>();
        int rowBegin=0;
        int rowEnd=matrix.length-1;
        int colBegin=0;
        int colEnd=matrix[0].length-1;

        if (matrix.length == 0) {
            return list;
        }
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //traverse right
            for(int j=colBegin;j<=colEnd;j++){
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //traverse down
            for(int i=rowBegin;i<=rowEnd;i++){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    list.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                // Traverse Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    list.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        return list;
    }
}