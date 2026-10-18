class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add boundary O's to the queue
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') {
                board[r][0] = 'T';
                queue.offer(new int[]{r, 0});
            }

            if (board[r][col - 1] == 'O') {
                board[r][col - 1] = 'T';
                queue.offer(new int[]{r, col - 1});
            }
        }

        for (int c = 0; c < col; c++) {
            if (board[0][c] == 'O') {
                board[0][c] = 'T';
                queue.offer(new int[]{0, c});
            }

            if (board[row - 1][c] == 'O') {
                board[row - 1][c] = 'T';
                queue.offer(new int[]{row - 1, c});
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        // Protect all O's connected to the boundary
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < row && nc < col
                        && board[nr][nc] == 'O') {
                    board[nr][nc] = 'T';
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // Convert surrounded O's to X and restore safe cells
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}