class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][]= new int[m][n];
        for(int i=0;i<m;i++){
            arr[i][0]=1;
        }for(int i=0;i<n;i++){
            arr[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];//i-1 for above and j-1 for left
            }
        }
        return arr[m-1][n-1];
    }
}//In summary, this code uses a dynamic programming approach to solve the problem. It initializes the leftmost column and top row with 1, representing the base cases.
//Time complexity:O(m*n)
//The code uses a 2D array arr of size m by n to store the count of unique paths to each cell. Therefore, the space complexity due to the array is O(m * n).





