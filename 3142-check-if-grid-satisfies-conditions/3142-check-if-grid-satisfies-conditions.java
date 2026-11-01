
class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Check the cell below
                if (i + 1 < rows &&
                    grid[i][j] != grid[i + 1][j]) {
                    return false;
                }

                // Check the cell to the right
                if (j + 1 < cols &&
                    grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
