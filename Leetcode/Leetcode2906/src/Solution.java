class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int m = grid.length;
        int n = grid[0].length;
        int[][] p = new int[m][n];

        long suf = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                p[i][j] = (int)suf;
                suf = suf * grid[i][j] % MOD;
            }
        }

        long pre = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = (int)(p[i][j] * pre % MOD);
                pre = pre * grid[i][j] % MOD;
            }
        }
        return p;
    }
}