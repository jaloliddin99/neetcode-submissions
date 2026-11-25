class Solution {
    private boolean[][] visit;

    public void islandsAndTreasure(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new ArrayDeque<>();
                  
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0},{0, 1}, {0, -1}};

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int distance = grid[cell[0]][cell[1]];
                for(int[] direction: directions){
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];

                    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length 
                    || grid[row][col] == -1){
                        continue;
                    }

                    if(grid[row][col] == Integer.MAX_VALUE){
                        grid[row][col] = distance + 1;
                        queue.offer(new int[]{row, col});
                    }
                }

            }
        }
        
    }

    


    
}
