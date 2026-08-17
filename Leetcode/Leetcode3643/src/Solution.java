class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        // i遍历子矩阵上半部分行
        for(int i = x; i < x + k/2; i++){
            int mirrorRow = 2*x + k -1 - i; //镜像行
            for(int j = y; j < y + k; j++){
                //swap grid[i][j] <-> grid[mirrorRow][j]
                int t = grid[i][j];
                grid[i][j] = grid[mirrorRow][j];
                grid[mirrorRow][j] = t;
            }
        }
        return grid;
    }
}
