class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    if (!chars.add(c)) {
                        return false;
                    }
                }
            }
        }

        // 2. Check columns
        for (int i = 0; i < 9; i++) {
            Set<Character> chars = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (Character.isDigit(c)) {
                    if (!chars.add(c)) {
                        return false;
                    }
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
