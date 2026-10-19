class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        int[][] efforts=new int[rows][cols];
        for(int row[]:efforts){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int[][] directions={
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        efforts[0][0]=0;
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int currEffort=curr[2];

            if(row==rows-1 && col==cols-1){
                return currEffort;
            }

            if(currEffort>efforts[row][col]){
                continue;
            }
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    int difference = Math.abs(
                        heights[row][col] - heights[newRow][newCol]
                    );

                    int newEffort = Math.max(currEffort, difference);

                    if (newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;

                        pq.add(new int[]{
                            newRow, newCol, newEffort
                        });
                    }
                }
            }
        }
        return 0;
    }
}