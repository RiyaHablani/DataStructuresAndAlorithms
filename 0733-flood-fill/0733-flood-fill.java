class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row=image.length;
        int col=image[0].length;
        int originalColor = image[sr][sc];
        boolean[][] visited=new boolean[row][col];

        dfs(image,sr,sc,color,originalColor,visited);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color,int originalColor,boolean[][] visited){

        int row=image.length;
        int col=image[0].length;

        if(r<0 || c<0 || r>=row || c>=col || visited[r][c] || image[r][c]!=originalColor ){
            return;
        }
        
        image[r][c] = color;
        visited[r][c] = true;

        dfs(image,r-1,c,color,originalColor,visited);
        dfs(image,r+1,c,color,originalColor,visited);
        dfs(image,r,c+1,color,originalColor,visited);
        dfs(image,r,c-1,color,originalColor,visited);
    }
}