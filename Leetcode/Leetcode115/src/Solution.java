class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(m - 1, n - 1, s.toCharArray(), t.toCharArray(), memo);
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        if (i < j) {
            return 0;
        }
        if (j < 0) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = dfs(i - 1, j, s, t, memo);
        if (s[i] == t[j]) {
            res += dfs(i - 1, j - 1, s, t, memo);
        }
        return memo[i][j] = res;
    }
}