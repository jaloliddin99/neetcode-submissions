class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
                    if(board[i][j] == 'O'){
                        dfs(board, i, j, '#');
                    }
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, char mark){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }

        board[i][j] = mark;
        dfs(board, i + 1, j, mark);
        dfs(board, i - 1, j, mark);
        dfs(board, i, j - 1, mark);
        dfs(board, i, j + 1, mark);
    }
}
