class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int[] row : grid) {
            for (int x : row) {
                total += x;
            }
        }
        return check(grid, total) || check(rotate(grid), total);
    }

    // 能否水平分割
    private boolean check(int[][] a, long total) {
        long s = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int x : a[i]) {
                s += x;
            }
            if (s * 2 == total) {
                return true;
            }
        }
        return false;
    }
    // 矩阵顺时针旋转
    private int[][] rotate(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] b = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j][m - 1 - i] = a[i][j];
            }
        }
        return b;
    }
}