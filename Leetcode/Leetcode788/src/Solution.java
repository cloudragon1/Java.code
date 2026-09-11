import java.util.Arrays;

class Solution {
    public static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    public int rotatedDigits(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int[][] memo = new int[s.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s, memo);
    }

    private int dfs(int i, int hasDiff, boolean isLimit, char[] s, int[][] memo) {
        if (i == s.length) {
            return hasDiff;
        }
        if (!isLimit && memo[i][hasDiff] >= 0) {
            return memo[i][hasDiff];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int j = 0; j <= up; j++) {
            if (DIFFS[j] != -1) {
                res += dfs(i + 1, hasDiff | DIFFS[j], isLimit && j == up, s, memo);
            }
        }
        return res;
    }
}