class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    oranges++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        if (oranges == 0) {
            return 0;
        }
        
    
        int time = 0;
        while(!q.isEmpty()) {
            time++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int[] pos = q.poll();
                for (int[] dir : directions) {
                    int r = pos[0] + dir[0];
                    int c = pos[1] + dir[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == 1) {
                        q.offer(new int[]{r,c});
                        grid[r][c] = 2;
                        oranges--;
                    }
                }
            }
        }
        
        return oranges == 0 ? time-1 : -1;
    }
}