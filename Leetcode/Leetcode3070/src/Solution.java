/*
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
                if (sum[i + 1][j + 1] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        int n = grid[0].length;
        int[] column = new int[n];
        for (int[] ints : grid) {
            int s = 0;
            for (int i = 0; i < n; i++) {
                column[i] += ints[i];
                s += column[i];

                if (s > k) {
                    break;
                }else {
                    ans++;
                }
            }
        }
        return ans;
    }
}