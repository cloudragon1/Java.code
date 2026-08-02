class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = piles[i];
            for (int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
            }
        }

        return f[0][n - 1] >= 0;
    }
}