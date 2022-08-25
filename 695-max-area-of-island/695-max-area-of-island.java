class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, direction));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j, int[][] direction) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i, j});
        grid[i][j] = 0;
        int area = 1;
        while(!s.isEmpty()) {
            int[] pos = s.pop();
            grid[pos[0]][pos[1]] = 0;
            for (int[] dir : direction) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] != 0) {
                    area++;
                    grid[r][c] = 0;
                    s.push(new int[]{r,c});
                }
            }
        }
        return area;
    }
}