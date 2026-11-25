class Solution {
    int rows = 0;
    int cols = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights[0][c], heights);
            dfs(rows - 1, c, atl, heights[rows - 1][c], heights);
        }

        // Left (Pacific) and right (Atlantic) edges
        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, cols - 1, atl, heights[r][cols - 1], heights);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pac[r][c] && atl[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visit, int prevHeight, int[][] heights) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || visit[row][col]
                || heights[row][col] < prevHeight) {
            return;
        }

        visit[row][col] = true;

        dfs(row + 1, col, visit, heights[row][col], heights);
        dfs(row - 1, col, visit, heights[row][col], heights);
        dfs(row, col + 1, visit, heights[row][col], heights);
        dfs(row, col - 1, visit, heights[row][col], heights);
    }
}
