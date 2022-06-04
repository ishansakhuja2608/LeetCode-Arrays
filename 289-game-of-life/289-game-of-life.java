class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = new int[]{1, -1, 1, -1, 0, 0, 1, -1};
        
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                int liveNeighbors = 0;
                for(int i = 0; i < 8; i++) {
                    int currX = row + dx[i];
                    int currY = col + dy[i];
                    if(isValidNeighbor(currX, currY, board) && Math.abs(board[currX][currY]) == 1)
                        liveNeighbors++;
                }
                if(board[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[row][col] = -1; // will update to 0 later
                if(board[row][col] == 0 && liveNeighbors == 3)
                    board[row][col] = 2; // will update to 1 later
            }
        }
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == -1)
                    board[row][col] = 0;
                else if(board[row][col] == 2)
                    board[row][col] = 1;
            }
        }
    }
    
    private boolean isValidNeighbor(int x, int y, int[][] board) {
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length);
    }
}