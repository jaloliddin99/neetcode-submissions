class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            minutes++;
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();

                for(int[] direction: directions){
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];

                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
                        continue;
                    }
                    if(grid[row][col] == 1){
                        grid[row][col] = 2;
                        fresh--;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
        
    }
}
