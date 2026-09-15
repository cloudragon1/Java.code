class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            char[] row = boxGrid[i];
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                char ch = row[j];
                if (ch == '#') {
                    cnt++;
                    ch = '.';
                }
                ans[j][m - i - 1] = ch;
                if (j == n - 1 && row[j + 1] == '*') {
                    for (int k = j; k > j - cnt; k--) {
                        ans[k][m - 1 - i] = '#';
                    }
                    cnt = 0;
                }
            }
        }
        return ans;
    }
}