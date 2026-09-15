class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m0 = grid.length, n0 = grid[0].length;
        for (int i = 0; i < Math.min(m0, n0) / 2; i++) {
            int m = m0 - i * 2 - 1, n = n0 - i * 2 - 1;
            int size = (m + n) * 2;
            int shift = k % size;
            reverse(grid, i, m, n, 0, shift - 1);
            reverse(grid, i, m, n, shift, size - 1);
            reverse(grid, i, m, n, 0, size - 1);
        }
        return grid;
    }

    public void reverse(int[][] grid, int i, int m, int n, int l, int r){
        while (l < r) {
            int[] p1 = index(i, m, n, l);
            int[] p2 = index(i, m, n, r);
            int x1 = p1[0], y1 = p1[1];
            int x2 = p2[0], y2 = p2[1];

            int tmp = grid[x1][y1];
            grid[x1][y1] = grid[x2][y2];
            grid[x2][y2] = tmp;
            l++;
            r--;
        }
    }

    public int[] index(int i, int m, int n, int p) {
        if (p < n) {
            return new int[] {i, i + p};
        }
        if (p < m + n) {
            return new int[] {i + p - n, i + n};
        }
        if (p < n * 2 + m) {
            return new int[] {i + m, i - p + n * 2 + m};
        }
        return new int[] {i - p + (n + m) * 2, i};
    }
}