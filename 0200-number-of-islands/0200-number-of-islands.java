class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        // base case: out of bounds or water
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';       // mark visited by sinking it

        dfs(i + 1, j, grid);    // down
        dfs(i - 1, j, grid);    // up
        dfs(i, j + 1, grid);    // right
        dfs(i, j - 1, grid);    // left
    }
}