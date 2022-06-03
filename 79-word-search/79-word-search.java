class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                if(board[i][j] == word.charAt(0) && search(board, i, j, 0, word))  // 0 is the number of characters found
                    return true;
        
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, int count, String word){
        if(count == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count))
            return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean found = search(board, i+1, j, count+1, word) || search(board, i-1, j, count+1, word) ||
                        search(board, i, j+1, count+1, word) || search(board, i, j-1, count+1, word);
        board[i][j] = temp;
        
        return found;
    }
}