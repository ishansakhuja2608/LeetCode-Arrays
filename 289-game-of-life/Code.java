class Solution {
    
    private int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++){
            
                if(board[i][j] == 1) {
                    int active = getActive(board, i, j);
                    if(active < 2 || active > 3)
                        board[i][j] = -2; // it's gonna be 0 as per the conditions povided
                }
                else if(board[i][j] == 0) {
                    int active = getActive(board, i, j);
                    if(active == 3)
                        board[i][j] = 3; // it's gonna be 1 as per the consitions
                } 
            }
        }
        updateBoard(board);
        return;
    }
    
    private void updateBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == -2)
                    board[i][j] = 0;
                if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }
    
    private int getActive(int[][] board, int row, int col) {
        int active = 0;
        for(int[] direction : directions ) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length &&
              (board[newRow][newCol] == 1 || board[newRow][newCol] == -2)){
                active++;
            }
        }
        return active;
    }
}
