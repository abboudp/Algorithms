class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    public int[][] dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < image.length && r >= 0 && c < image[0].length && c >= 0 && image[r][c] == oldColor) {
            image[r][c] = newColor;
            dfs(image, r + 1, c, oldColor, newColor);
            dfs(image, r - 1, c, oldColor, newColor);
            dfs(image, r, c + 1, oldColor, newColor);
            dfs(image, r, c - 1, oldColor, newColor);
        }
        return image;
    }
}