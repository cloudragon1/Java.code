class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] tailZeros = new int[n];
        for (int i = 0; i < n; i++) {
            tailZeros[i] = n;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    tailZeros[i] = n - j - 1;
                    break;
                }
            }
        }

        int ans = 0;
        next:
        for (int i = 0; i < n - 1; i++) {
            int needZeros = n - 1 - i;
            for (int j = i; j < n; j++) {
                if (tailZeros[j] >= needZeros) {
                    ans += j - i;
                    System.arraycopy(tailZeros, i, tailZeros, i + 1, j - i);
                    continue next;
                }
            }
            return -1;
        }
        return ans;
    }
}