class Solution {
    int rows;
    int cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int currColor = image[sr][sc];

        dfs(sr, sc, currColor, color, visited, image);
        return image;
    }

    void dfs(int row, int col, int currColor, int newColor, boolean[][] visited, int[][] image) {
        // out of bound case
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
            visited[row][col] || image[row][col] != currColor) {
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;

        // neighbour
        int adjList[][] = {{row-1,col},{row,col+1},{row+1,col},{row,col-1}};
        for (int neighbour[] : adjList) {
            dfs(neighbour[0], neighbour[1], currColor, newColor, visited, image);
        }
    }
}
