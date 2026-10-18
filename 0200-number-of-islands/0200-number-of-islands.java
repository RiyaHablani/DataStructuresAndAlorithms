class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int count=0;
        boolean[][] visited=new boolean[row][col];
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c]=='1' && !visited[r][c]){
                    dfs(grid,visited,r,c);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,boolean[][] visited,int r,int c){
        int row=grid.length;
        int col=grid[0].length;
        if(r<0 || c<0 || r>=row || c>=col || visited[r][c] || grid[r][c]=='0'){
            return;
        }
        visited[r][c]=true;
        dfs(grid, visited, r - 1, c);
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r, c - 1);
        dfs(grid, visited, r, c + 1);
    }
}