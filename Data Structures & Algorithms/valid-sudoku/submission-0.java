class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (chars.contains(board[i][j])) {
                        return false;
                    }
                    chars.add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[j][i])) {
                    if (chars.contains(board[j][i])) {
                        return false;
                    }
                    chars.add(board[j][i]);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                int row = (i / 3) * 3 + j / 3;
                int col = (i % 3) * 3 + j % 3;
                char c = board[row][col];
                if (Character.isDigit(c)) {
                    if (!chars.add(c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
