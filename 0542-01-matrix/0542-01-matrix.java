class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        
        Queue<int[]> queue=new LinkedList<>();

        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(mat[r][c]==0){
                    queue.offer(new int[]{r,c});
                }else{
                    mat[r][c]=-1;
                }
            }
        }

        int[][] directions={
            {1,0},{-1,0},{0,1},{0,-1}
        };

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] curr=queue.poll();
                
                int r=curr[0];
                int c=curr[1];

                for(int dir[]: directions){
                    int nr=r+dir[0];
                    int nc=c+dir[1];

                    if (nr >= 0 && nc >= 0 && nr < row && nc < col && 
                    mat[nr][nc] == -1) {
                        mat[nr][nc]=mat[r][c]+1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return mat;
    }
}