/*
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] sum = new int[m+1][n+1][2];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1][0] = sum[i][j + 1][0] + sum[i + 1][j][0] - sum[i][j][0];
                sum[i + 1][j + 1][1] = sum[i][j + 1][1] + sum[i + 1][j][1] - sum[i][j][1];
                if (grid[i][j] != '.') {
                    sum[i + 1][j + 1][grid[i][j] & 1]++;
                }
                if (sum[i + 1][j + 1][0] > 0 && sum[i + 1][j + 1][0] == sum[i + 1][j + 1][1]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}*/


class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int[][] cnt = new int[grid[0].length][2];
        int ans = 0;
        for (char[] row : grid) {
            int X = 0;
            int Y = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] != '.') {
                    cnt[i][row[i] & 1]++;
                }
                X += cnt[i][0];
                Y += cnt[i][1];

                if (X > 0 && X == Y) {
                    ans++;
                }
            }
        }
        return ans;
    }
}