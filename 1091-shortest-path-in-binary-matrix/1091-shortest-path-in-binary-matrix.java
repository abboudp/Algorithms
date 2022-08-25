class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] directions = new int[][]{{0,1},{1,1},{-1,1},{1,-1},{-1,0},{0,-1},{-1,-1}, {1,0}};
        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        path.add(0);
        q.offer(path);
        grid[0][0] = 1;
        while (!q.isEmpty()) {
            path = q.poll();
            if (path.get(0) == grid.length - 1 && path.get(1) == grid[0].length - 1) {
                return grid[path.get(0)][ path.get(1)];
            }
            for (int[] dir : directions) {
                int r = path.get(0) + dir[0];
                int c = path.get(1) + dir[1];
                List<Integer> newPath = new ArrayList<>();
                newPath.add(r);
                newPath.add(c);
                if (c >= 0 && c < grid.length && r < grid[c].length && r >= 0 && !visited.contains(newPath) && grid[r][c] != 1) {
                    visited.add(newPath);
                    q.offer(newPath);
                    grid[r][c] = grid[path.get(0)][path.get(1)] + 1;
                }
            }
        }
        return -1;
    }
}