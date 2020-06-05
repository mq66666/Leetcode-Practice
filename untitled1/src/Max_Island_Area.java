public class Max_Island_Area {
    class Solution {
        int r;
        int c;
        int[][] grid;

        public int maxAreaOfIsland(int[][] grid) {
            int max_area = 0;
            if (grid == null || grid.length == 0) {
                return 0;
            }
            this.grid = grid;
            this.r = grid.length;
            this.c = grid[0].length;
            for (int i = 0; i <= r-1; i++) {
                for (int j = 0; j <= c-1; j++) {
                    if (grid[i][j] == 1) {
                        int area = 1;
                        max_area = Math.max(max_area, dfs(i, j, area));
                    }
                }
            }
            return max_area;
        }

        public int dfs(int i, int j, int area) {
            grid[i][j] = 0;
            int sub_area = area;
            if (i + 1 <= r-1 && grid[i + 1][j] == 1) {
                sub_area = sub_area + dfs(i + 1, j, area);

            }
            if (j + 1 <= c-1 && grid[i][j + 1] == 1) {
                sub_area = sub_area + dfs(i,j+1,area);

            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                sub_area = sub_area + dfs(i - 1, j, area);

            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                sub_area = sub_area + dfs(i , j-1, area);

            }

            return sub_area;
        }
    }
}
