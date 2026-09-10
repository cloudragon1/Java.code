import java.util.Arrays;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] memo = new int[m][n][k + 1];

        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        int ans = dfs(m - 1, n - 1, k, grid, memo);
        return ans < 0 ? -1 : ans;
    }
    private int dfs(int i, int j, int k, int[][] grid, int[][][] memo) {
        if (i < 0 || j < 0 || k < 0) {
            return Integer.MIN_VALUE;
        }
        if (i == 0 && j == 0) {
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        int x = grid[i][j];
        int newK = x > 0 ? k - 1 : k;
        return memo[i][j][k] = Math.max(dfs(i - 1, j, newK, grid, memo), dfs(i, j - 1, newK, grid, memo)) + x;
    }
}